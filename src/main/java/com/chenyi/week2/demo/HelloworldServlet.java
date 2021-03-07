package com.chenyi.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloworldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Name:chenyi");
        writer.println("ID:2019211001000829");
        writer.println("Date and Time Sat Mar 14 20:30:25 CST 2021");
    }
}
