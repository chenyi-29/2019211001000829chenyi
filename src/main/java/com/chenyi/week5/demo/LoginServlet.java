package com.chenyi.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet (name="LoginServlet",value="/login")

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String sql = "select * from usertable";
            try {
                ResultSet rs = con.createStatement().executeQuery(sql);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
