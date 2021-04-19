package com.example.schooldemo1;



import com.example.domain.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        UserService service=new UserServiceImpl();
        User user=service.findUserById(id);
        request.setAttribute("user",user);
        //System.out.println("user"+user);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
        //System.out.println("dispatch ok");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
