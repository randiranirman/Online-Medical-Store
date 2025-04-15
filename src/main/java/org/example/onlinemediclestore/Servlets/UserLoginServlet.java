package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.FileHandlers.UserFileHandler;

import java.util.List;

public class UserLoginServlet  extends HttpServlet
{
    protected  void doPost (HttpServletRequest request, HttpServletResponse response)  {
        String username = request.getParameter("username");
        String password = request.getParameter("password");




    }
    protected  void doGet (HttpServletRequest request, HttpServletResponse response){


    }

}
