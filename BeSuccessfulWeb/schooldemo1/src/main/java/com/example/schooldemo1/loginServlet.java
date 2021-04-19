package com.example.schooldemo1;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import static org.graalvm.compiler.options.OptionType.User;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User loginUser=new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        UserDao dao=new UserDaoImpl();
        User user=dao.login(loginUser);
        if(user==null){
            System.out.println("login failed");
            request.getRequestDispatcher("/FailServlet").forward(request, response);
        }else{
            request.setAttribute("user",user);
            System.out.println("login");
            request.getRequestDispatcher("/SuccessServlet").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
