package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.Customer;
import org.example.onlinemediclestore.Classes.Medicine;
import org.example.onlinemediclestore.Classes.Order;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;
import org.example.onlinemediclestore.utils.QueueHelper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;


@WebServlet("/orderProcessing")
public class OrderProcessingServlet extends HttpServlet {

    private  final  String FILEPATH = Config.ORDERS.getPath();
    private static final QueueHelper helper = new QueueHelper();


    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession()
;
        Customer customer = (Customer)  session.getAttribute("user");

        if( customer == null){
            System.out.println("customer is null");
            response.sendRedirect("login.jsp?redirect=viewproductnew");

            return;
        }



        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String medicineId= request.getParameter("medicineId");


        if( medicineId == null ||  medicineId.isEmpty()){

            request.setAttribute("error", "medicine not found");


        }
        String address = request.getParameter("address");

        System.out.println(address);

        if( address.isEmpty() || address.trim().isEmpty()){

            request.setAttribute("error", "shipping address is required");
            
            request.getRequestDispatcher("viewProduct?id=" + medicineId).forward(request, response);
            return;
        }
        
        GenericCRUD<Medicine> medicineGenericCRUD= new GenericCRUD<>(Medicine.class, Config.MEDICINES.getPath());
        Optional<Medicine> medicineOptional= medicineGenericCRUD.findOneById(medicineId);
        if( !medicineOptional.isPresent()){
            request.setAttribute("error", "medicine not found");
            System.out.println("This got  executed ");
            request.getRequestDispatcher("viewProductDetails").forward(request, response);
            return;
        }
        Medicine medicine = medicineOptional.get();
        System.out.println("medicine found ");

        // check the quantity
        if( !medicine.isAvailable() || medicine.getQuantity() < quantity){
            request.setAttribute("error","requsted quantity not available ");
            request.getRequestDispatcher("viewProduct?id=" + medicineId).forward(request, response);
            return;
        }


        String orderId = UUID.randomUUID().toString();
        String status = "Pending";
        LocalDateTime orderDate = LocalDateTime.now();
        System.out.println("local date time ");
        String fullName = request.getParameter("fullName");
        String phoneNumber= request.getParameter("phone");


        // calculate the total price
        double totalPrice = medicine.getPrice() * quantity;
        // creating a new order
        Order order= new Order(
                orderId,
                medicine.getName(),
                customer,
                medicine,
                quantity    ,
                address,
                totalPrice,
                status,
                orderDate,
                fullName,
                phoneNumber
        );
        // save order
        GenericCRUD<Order> orderGenericCRUD= new GenericCRUD<>(Order.class, Config.ORDERS.getPath());
        orderGenericCRUD.add(order);

        // update medicine quantity
        int newQuantity =  medicine.getQuantity() - quantity;
        medicine.setQuantity(newQuantity);

        if (newQuantity == 0) {
            medicine.setAvailable(false);
        }

        // create a predicate to find the medicine to update

        Predicate<Medicine> medicinePredicate= med -> med.getId().equals(medicine.getId());
        medicineGenericCRUD.update(medicinePredicate, medicine);
        // set Order in session for confirmation page
        session.setAttribute("last order", order);
        System.out.println("order processing done ");
        synchronized (helper){
            helper.enqueue(order);
        }
        // redirect to the order confirmation page
        response.sendRedirect("orderConfirmation?orderId+" +  orderId);













    }
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        // redirect to the products page if accessed successful
        response.sendRedirect("viewMedicine");


    }
}
