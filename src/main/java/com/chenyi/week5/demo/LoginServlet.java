package com.chenyi.week5.demo;

import com.chenyi.dao.Userdao;
import com.chenyi.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {
            Connection con=null;
            @Override
            public  void init() throws ServletException {
            ServletConfig config = getServletConfig();
            String driver = config.getInitParameter("driver");
            String url = config.getInitParameter("url");
            String username = config.getInitParameter("username");
            String password = config.getInitParameter("password");

            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, username, password);

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Userdao userdao=new Userdao();
            try {
                User user=userdao.findByUsernamePassword(con,username,password);
                if (user!=null){
                    String rememberMe=request.getParameter("rememberMe");
                    if (rememberMe!=null&& rememberMe.equals("1")){
                        Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                        Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                        Cookie rememberMeCookie=new Cookie("remember",rememberMe);
                        usernameCookie.setMaxAge(5);
                        passwordCookie.setMaxAge(5);
                        rememberMeCookie.setMaxAge(5);
                        response.addCookie(usernameCookie);
                        response.addCookie(passwordCookie);
                        response.addCookie(rememberMeCookie);
                    }
                    HttpSession session=request.getSession();
                    System.out.println("session id-->"+session.getId());
                    session.setMaxInactiveInterval(10);
                    Cookie c=new Cookie("sssionid",""+user.getId());
                    c.setMaxAge(10*60);
                    response.addCookie(c);
                    session.setAttribute("user",user);
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
                    request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
