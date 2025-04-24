        package org.example.onlinemediclestore.Servlets;
    
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        import org.example.onlinemediclestore.Classes.Admin;
        import org.example.onlinemediclestore.Classes.Customer;
        import org.example.onlinemediclestore.Classes.Supplier;
        import org.example.onlinemediclestore.FileConfig.Config;
        import org.example.onlinemediclestore.utils.GenericCRUD;
    
        import java.io.IOException;
    
        @WebServlet("/delete")
        public class DeleteServlet extends HttpServlet {
    
            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
                String type = request.getParameter("type");        //  "customer", "supplier"
                String username = request.getParameter("username");
    
                if (type == null || type.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing type parameter.");
                    return;
                }
    
                switch (type) {
                    case "supplier":
                        if (username != null && !username.trim().isEmpty()) {
                            GenericCRUD<Supplier> supplierCRUD = new GenericCRUD<>(Supplier.class, Config.SUPPLIERS.getPath());
                            supplierCRUD.delete(s -> username.equals(s.getUsername()));
                            System.out.println("Supplier deleted: " + username);
                                response.sendRedirect(request.getContextPath() + "/supplier");
                        } else {
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing supplier username.");
                        }
                        break;
    
                    case "customer":
                        if (username != null && !username.trim().isEmpty()) {
                            GenericCRUD<Customer> customerCRUD = new GenericCRUD<>(Customer.class, Config.USERS.getPath());
                            customerCRUD.delete(c -> c.getUsername().equals(username));
                            System.out.println("Customer deleted: " + username);
                            response.sendRedirect(request.getContextPath() + "/user");
                        } else {
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing customer username.");
                        }
                        break;
                    case "admin":
                        if( username != null && !username.trim().isEmpty()){
                            GenericCRUD<Admin> adminGenericCRUD= new GenericCRUD<>(Admin.class,Config.ADMINS.getPath());
                            adminGenericCRUD.delete(a -> a.getUsername().equals(username));
                            System.out.println("admin deleted " + username);
                            response.sendRedirect( request.getContextPath() +  "/admin-creation");
                        }else {

                            response.sendError(HttpServletResponse.SC_BAD_REQUEST , "missing username " );


                        }
                        break;


    
    
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid deletion type.");
                }
            }
        }
