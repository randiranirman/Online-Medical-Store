package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.PasswordHasher;
import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileHandlers.SupplierFileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CreateSupplier")

public class AdminServlet  extends HttpServlet {
    SupplierFileHandler handler  = new SupplierFileHandler()
;

    protected  void doPost (HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name");
    String username= request.getParameter("username");
    String password = PasswordHasher.hashPassword( request.getParameter("password"));
    String email = request.getParameter("email");

    String companyName =  request.getParameter("companyName");
    String address = request.getParameter("address");

        // read existing supplier form  file
        Supplier supplier = new Supplier(name, username, password, email, companyName,address);
        List<Supplier> supplierList=  handler.readSupplierFromFile();

        // add new supplier
        supplierList.add(supplier);

        // pass data  to jsp
        request.setAttribute("supplier" , supplier);

        request.getRequestDispatcher("supplier.jsp").forward(request, response);







    }
    protected  void doGet( HttpServletRequest request, HttpServletResponse response)  throws  IOException,ServletException{


    }
}
