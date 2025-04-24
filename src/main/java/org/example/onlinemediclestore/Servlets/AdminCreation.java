package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Admin;
import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;
import org.example.onlinemediclestore.utils.PasswordHasher;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/admin-creation")
public class AdminCreation  extends HttpServlet  {
        private final GenericCRUD<Admin> adminCRUD = new GenericCRUD<Admin>(Admin.class, Config.ADMINS.getPath())
;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get parameters
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String rawPassword = request.getParameter("password");

        // Validate inputs first
        if (name == null || name.isBlank() ||
                username == null || username.isEmpty() ||
                email == null || email.isEmpty() ||
                rawPassword == null || rawPassword.isEmpty()) {

            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("viewAdmins.jsp").forward(request, response);
            return;
        }

        // Check for duplicate username before adding
        List<Admin> adminList = adminCRUD.readAll();
        for (Admin adminInList : adminList) {
            if (adminInList.getUsername().equals(username)) {
                request.setAttribute("error", "Username already exists");
                request.getRequestDispatcher("viewAdmins.jsp").forward(request, response);
                return;
            }
        }

        // Hash password and create admin
        String password = PasswordHasher.hashPassword(rawPassword);
        String role = "admin";
        Admin admin = new Admin(name, username, password, role, email);

        // Add admin to database
        adminCRUD.add(admin);

        // Redirect to trigger doGet
        response.sendRedirect(request.getContextPath() + "/admin-creation");
    }
    protected  void doGet( HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException{

        List<Admin> adminList = adminCRUD.readAll();
        System.out.println("get method executed");

        // Pass the list to JSP
        request.setAttribute("admins", adminList);
        request.getRequestDispatcher( "viewAdmins.jsp").forward(request, response);

    }


}
