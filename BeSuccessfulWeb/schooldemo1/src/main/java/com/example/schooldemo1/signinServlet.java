package com.example.schooldemo1;

import com.example.dao.UserSign;
import com.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signinServlet")
public class signinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String age=request.getParameter("age");

        String address=request.getParameter("address");
        String qq=request.getParameter("qq");

        String email=request.getParameter("email");
        String gender=request.getParameter("gender");

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User signinUser=new User();
        signinUser.setName(name);
        signinUser.setAge(Integer.parseInt(age));
        signinUser.setAddress(address);
        signinUser.setQq(qq);
        signinUser.setEmail(email);
        signinUser.setGender(gender);
        signinUser.setUsername(username);
        signinUser.setPassword(password);
        UserSign dao=new UserSign();
        int user=dao.sign(signinUser);
        if(user<=0){
            System.out.println("signin failed");
            request.getRequestDispatcher("/SignFail").forward(request, response);
        }else{
            request.setAttribute("user",signinUser);
            System.out.println("login");
            request.getRequestDispatcher("/SignSuccess").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}