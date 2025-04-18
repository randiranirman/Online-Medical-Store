package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Customer;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class AdminUserServlet extends HttpServlet {
    private final String userFilePath = Config.USERS.getPath();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Post method implementation here
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // using the generic class
            GenericCRUD<Customer> userCrud = new GenericCRUD<>(Customer.class, userFilePath);

            List<Customer> users = userCrud.getAll();


            if (users == null || users.isEmpty()) {
                request.setAttribute("message", "No users found in the database.");
            }

            // Always set the userList attribute
            request.setAttribute("userList", users);

            // Forward to the JSP
            request.getRequestDispatcher("viewUsers.jsp").forward(request, response);
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();

            // Set error message
            request.setAttribute("message", "Error retrieving users: " + e.getMessage());
            request.setAttribute("userList", null);

            // Forward to the JSP
            request.getRequestDispatcher("viewUsers.jsp").forward(request, response);

        }
    }
}