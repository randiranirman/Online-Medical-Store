package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.utils.PasswordHasher;
import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileHandlers.SupplierFileHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/supplier")
public class AdminServlet extends HttpServlet {
    SupplierFileHandler handler = new SupplierFileHandler();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = PasswordHasher.hashPassword(request.getParameter("password"));
        String email = request.getParameter("email");
        String companyName = request.getParameter("companyName");
        String address = request.getParameter("address");

        Supplier supplier = new Supplier(name, username, password, email, companyName, address);
        handler.writeSupplierToFile(supplier); // save new supplier

        // Redirect to the same servlet (which triggers doGet)
        response.sendRedirect(request.getContextPath() + "/supplier");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Supplier> supplierList = handler.readSupplierFromFile();

        // Pass the list to JSP
        request.setAttribute("suppliers", supplierList);
        request.getRequestDispatcher( "viewSupplier.jsp").forward(request, response);
    }
}
