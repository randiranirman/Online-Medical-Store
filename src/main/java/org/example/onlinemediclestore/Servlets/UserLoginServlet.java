package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.Customer;
import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.FileHandlers.SupplierFileHandler;
import org.example.onlinemediclestore.utils.GenericCRUD;
import org.example.onlinemediclestore.utils.PasswordHasher;
import org.example.onlinemediclestore.Classes.User;
import org.example.onlinemediclestore.FileHandlers.UserFileHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> users = new UserFileHandler().getAllUsers();

        List<Supplier> suppliers = new SupplierFileHandler().readSupplierFromFile();

        // Check if the user is a normal user or admin
        for (User user : users) {
            if (user.getUsername().equals(username) && PasswordHasher.checkPassword(password, user.getPassword())) {
                HttpSession session = request.getSession();

                // Create the appropriate object based on role
                if (user.getRole().equals("customer")) {
                    // Create a Customer object before storing in session
                    Customer customer = new Customer(user.getUserID(),user.getName(), user.getUsername(), user.getPassword(),
                            "customer", user.getEmail());
                    session.setAttribute("user", customer);
                } else {
                    session.setAttribute("user", user);
                }

                session.setAttribute("role", user.getRole());

                switch (user.getRole()) {
                    case "admin":
                        response.sendRedirect(request.getContextPath() + "/admin.jsp");
                        break;
                    case "customer":
                        response.sendRedirect(request.getContextPath() + "/showProducts");

                        break;
                    default:
                        response.sendRedirect(request.getContextPath() + "/login.jsp?error=invalidRole");
                }
                return;
            }
        }

        // Check if the user is a supplier
        for (Supplier supplier : suppliers) {
            if (supplier.getUsername().equals(username) && PasswordHasher.checkPassword(password, supplier.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", supplier);
                session.setAttribute("role", supplier.getRole());

                response.sendRedirect(request.getContextPath() + "/supplier.jsp");
                return;
            }
        }

        // Login failed
        request.setAttribute("errorMessage","Invalid Username or Password");
        request.getRequestDispatcher("login.jsp").forward(request , response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}