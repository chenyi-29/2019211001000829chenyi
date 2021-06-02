package controller;

import dao.OrderDao;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AccountDetailsServlet", value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null&&session.getAttribute("user")!=null){
            user user=(user)session.getAttribute("user");
            int userId=user.getId();
            request.setAttribute("user",user);
            OrderDao orderDao=new OrderDao();
            List<Order> orderList=orderDao.findByUserId(con,userId);
            request.setAttribute("orderList",orderList);
            String path="/WEB-IF/views/accountDetails.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        }else{
            response.sendRedirect("Login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    private class User {
    }

    private class user {
        public int getId() {
            return 0;
        }
    }
}
