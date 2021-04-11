package com.chenyi.week6.demo;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context= sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String Username = context.getInitParameter("Username");
        String Password = context.getInitParameter("Password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,Username,Password);
            System.out.println("in contextInitialized()-->"+con);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("in contextDestroy");
        sce.getServletContext().removeAttribute("con ");
    }
}
