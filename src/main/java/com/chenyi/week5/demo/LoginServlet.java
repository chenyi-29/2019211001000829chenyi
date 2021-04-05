package com.chenyi.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet (name="LoginServlet",value="/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{
        super.init();
        ///TODO 1:GET 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        //TODO 2: GET JDBC connection
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        //TODO 4；VALIDATE USER - SELECT * FROM USERTABLE WHERE USERNAME ='XXX' AND PASSWORD = 'YYY'
        //TODO 5: CHECK IF(USER IS VALID){
        //OUT.PRINTLN("LOGIN SUCCESS !!!");
        //OUT.PRINT("WELCOME USERNAME");
        //}ELSE{
        //OUT.PRINT(LOGIN ERROR!!!);
        //}


    }
}
