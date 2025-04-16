package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.PasswordHasher;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.FileHandlers.UserFileHandler;
import org.example.onlinemediclestore.Interfaces.IUserFileHandler;
import org.example.onlinemediclestore.utils.JsonHelper;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/signup")
public class UserServlet extends HttpServlet {
    UserFileHandler userFileHandler= new UserFileHandler();



    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String password = PasswordHasher.hashPassword(request.getParameter("password"));
            String confirmPassword = request.getParameter("confirmPassword");
            String email = request.getParameter("email");
            String role = "customer";
            if( !request.getParameter("password").equals(confirmPassword)){
                request.setAttribute("error","Passwords do not match ");
                request.getRequestDispatcher("signup.jsp").forward(request,response);
                return;
            }



            // setting attributes in the session
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("name", name);
            session.setAttribute("password", password);

            User user = new User(name, username,password, role,email);
            session.setAttribute("user", user);
            userFileHandler.saveUser(user);


            //redirect to the daashboard if the signup is successfull
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/dashboard.jsp"));


        }catch(Exception e ){
            e.printStackTrace();
        }






    }

    public void doGet(HttpServletRequest request , HttpServletResponse response){


    }

}
