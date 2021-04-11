package com.chenyi.week6.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
    Connection search=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");
        if(txt == null){
            response.sendRedirect("index.jsp");
        }else{
            if(search.equals("Baidu")) {
                response.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }else if(search.equals("Bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
            }else if(search.equals("Google")){
                response.sendRedirect("https://www.google.com/search?q="+txt);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
