package org.example.onlinemediclestore.Servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Customer;
import org.example.onlinemediclestore.Classes.Supplier;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {


    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String name = request.getParameter("updatedName");
        String username  = request.getParameter("username");
        String updatedUsername = request.getParameter("updatedUsername");
        String email = request.getParameter("updatedEmail");


        String type = request.getParameter("type");

        if( type == null || type.isEmpty()){

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "type parameter is  required");
            return;
        }


        if( type.equals("supplier")){
            // getting these values if the user is a supplier
            String companyName = request.getParameter("updateCompanyName");
            String address = request.getParameter("updatedAddress");

            GenericCRUD<Supplier> supplierGenericCRUD= new GenericCRUD<>(Supplier.class, Config.SUPPLIERS.getPath());
            Supplier updatedSupplier = new Supplier(updatedUsername,name,email, companyName, address);
            // checking the username is valid
            supplierGenericCRUD.update( s -> s.getUsername().equals(username), updatedSupplier);
            // direct to the viewSupplier.jsp
            response.sendRedirect(request.getContextPath() + "/editUser");








        }else if( type.equals("customer")){
            GenericCRUD<Customer> customerGenericCRUD= new GenericCRUD<>(Customer.class, Config.USERS.getPath());
            Customer updatedCustomer = new Customer(updatedUsername, name , email);
            customerGenericCRUD.update(c -> c.getUsername().equals(username), updatedCustomer);
            response.sendRedirect(request.getContextPath() + "/editUser");


        }else{
           response.sendError(HttpServletResponse.SC_BAD_REQUEST,"invalid type value");
        }



    }
}
