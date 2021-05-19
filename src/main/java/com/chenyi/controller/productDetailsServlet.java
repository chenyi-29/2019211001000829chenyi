package com.chenyi.controller;

import com.chenyi.dao.IProductDao;
import com.chenyi.dao.ProductDao;
import com.chenyi.model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "productDetailsServlet", value = "/productDetails")
public class productDetailsServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (request.getParameter("id")!=null){
            int productId= Integer.parseInt(request.getParameter("id"));
            ProductDao productDao=new ProductDao();
            IProductDao.Product product=productDao.findById(productId,con);
            request.setAttribute("p",product);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
