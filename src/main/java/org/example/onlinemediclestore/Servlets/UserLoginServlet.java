package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.PasswordHasher;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.FileHandlers.UserFileHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class UserLoginServlet  extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> users = new UserFileHandler().getAllUsers();

        for (User user : users) {
            if (user.getUsername().equals(username) && PasswordHasher.checkPassword(password, user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Redirect to dashboard on success
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/dashboard.jsp"));
                return;
            }
        }

        // If login fails
        request.setAttribute("errorMessage", "Invalid username or password");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    protected  void doGet (HttpServletRequest request, HttpServletResponse response){


    }

}
