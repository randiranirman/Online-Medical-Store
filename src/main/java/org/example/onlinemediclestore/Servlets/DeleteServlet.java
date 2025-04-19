package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.util.List;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private final String FILEPATH = Config.SUPPLIERS.getPath();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");

        if (username != null && !username.trim().isEmpty()) {
            GenericCRUD<Supplier> supplierCRUD = new GenericCRUD<>(Supplier.class, FILEPATH);

            // Delete the supplier by username
            supplierCRUD.delete(s -> s.getUsername().equals(username));
            System.out.println("User deleted: " + username);

            // Redirect to the viewSupplier.jsp to fetch updated data
            response.sendRedirect(request.getContextPath() + "/viewSupplier.jsp");

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Username is missing.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GenericCRUD<Supplier> supplierCRUD = new GenericCRUD<>(Supplier.class, FILEPATH);

        // Read all suppliers
        List<Supplier> supplierList = supplierCRUD.readAll();

        // Set as attribute and forward to view
        request.setAttribute("supplierList", supplierList);
        request.getRequestDispatcher("/viewSupplier.jsp").forward(request, response);
    }
}
