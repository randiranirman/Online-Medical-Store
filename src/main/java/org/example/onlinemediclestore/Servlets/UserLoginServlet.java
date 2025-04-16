package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.FileHandlers.UserFileHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class UserLoginServlet  extends HttpServlet
{
    protected  void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> users = new UserFileHandler().getAllUsers();


        for(User user : users){
            if( user.getUsername().equals(username) && user.getPassword().equals(password)){
                HttpSession session  =request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "dashboard.jsp");
                return;
            }
        }




    }
    protected  void doGet (HttpServletRequest request, HttpServletResponse response){


    }

}
