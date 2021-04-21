package com.chenyi.controller;

import com.chenyi.dao.Userdao;
import com.chenyi.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UpdateuserServlet", value = "/Updateuser")
public class UpdateuserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/Updateuser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");
        String Birthdate = request.getParameter("Birthdate");
        Userdao userdao=new Userdao();
        try {
            User user=userdao.findByUsernamePassword(con,username,password);
            if (user!=null){
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql = "select * from usertable ";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if(rs.next()){
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("Username",rs.getString("Username"));
                request.setAttribute("password",rs.getString("Password"));
                request.setAttribute("Email",rs.getString("Email"));
                request.setAttribute("Gender",rs.getString("Gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userinfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or password error!!");
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


