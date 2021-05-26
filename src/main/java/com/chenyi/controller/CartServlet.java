package com.chenyi.controller;

import com.chenyi.dao.ProductDao;
import com.chenyi.model.Item;
import com.chenyi.model.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con =(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session!=null&&session.getAttribute("user")!=null){
            if (request.getParameter("action")==null){
                displayCart(request,response);
            }else  if (request.getParameter("action").equals("add")){
                buy(request,response);
            }else if (request.getParameter("action").equals("remove")){
                remove(request,response);
            }

        }else {
            response.sendRedirect("login");
        }

    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Item> cart=(List<Item>) request.getSession().getAttribute("cart");
        int id=0;
        if (request.getParameter("productId")!=null){
            id=Integer.parseInt(request.getParameter("productId"));
        }
        int index=isExisting(id,cart);
        cart.remove(index);
        request.getSession().setAttribute("cart",cart);
        String path=request.getContextPath()+"/cart";
        response.sendRedirect(path);
    }

    private void buy(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        int id=request.getParameter("productId")!=null?Integer.parseInt(request.getParameter("productId")):0;
        int quantity=request.getParameter("quantity")!=null?Integer.parseInt(request.getParameter("quantity")):0;
        if (id==0||quantity==0){
            return;
        }
        ProductDao productDao=new ProductDao();
        if(session.getAttribute("cart")==null){
            List<Item> cart=new ArrayList<Item>();
            product p=productDao.findById(id,con);
            cart.add(new Item(p,quantity));
            session.setAttribute("cart",cart);
        }else{
            List<Item>cart=(List<Item>) session.getAttribute("cart");
            int index=isExisting(id,cart);
            if (index==-1){
                product p=productDao.findById(id,con);
                cart.add(new Item(p,1));
            }else{
                int newQunatity=cart.get(index).getQunatity()+1;
                cart.get(index).setQunatity(newQunatity);
            }
            session.setAttribute("cart",cart);
        }
    }

    private int isExisting(int id, List<Item> cart) {
        for (int i=1;i<cart.size();i++){
            if (cart.get(i).getProduct().getProductId()==id){
                return i;
            }
        }
        return -1;
    }

    private void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Your cart");
        String path="/WEB-INF/views/cart.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
