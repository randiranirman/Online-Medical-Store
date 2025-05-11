package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.utils.PasswordHasher;

import java.io.IOException;


@WebServlet("/test")
public class TestServlet extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{


        String username = request.getParameter("username");

        String password= PasswordHasher.hashPassword(request.getParameter("password"));


    }
    protected  void deGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

    }

}
