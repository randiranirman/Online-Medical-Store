package org.example.onlinemediclestore.Servlets;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.Order;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/orderConfirmation")
public class OrderConfirmation extends HttpServlet {
    private final String FILEPATH = Config.ORDERS.getPath();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Redirect POST requests to GET
        response.sendRedirect("orderConfirmation");
    }


    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


            // get order Id from request paramter

        String orderId = request.getParameter("orderId");


        // check if we have an order Id in parameter
        if( orderId != null && !orderId.isEmpty()){
            // if  the paramter contains a  "++" , split it

            if( orderId.contains("+")){
                orderId=orderId.split("\\+")[1];
            }
                // get the order using id
            GenericCRUD<Order> orderGenericCRUD= new GenericCRUD<>(Order.class,Config.ORDERS.getPath())
;
            Optional<Order> orderOptional= orderGenericCRUD.findOneById(orderId);


            if( orderOptional.isPresent()){
                // set the order as a requset attribute
                request.setAttribute("order", orderOptional.get());
                request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
                return;

            }
        }

        // if we dont have  order id in the paramter , check sesion for last order
        HttpSession session= request.getSession();
        Order order = (Order) session.getAttribute("last order");

        if (order != null) {
            // Set the order as a request attribute
            request.setAttribute("order", order);

            // Remove the order from session to prevent viewing it multiple times
            session.removeAttribute("last order");

            request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
            return;
        }

        // If no order is found either in parameter or session, show error
        request.getRequestDispatcher("orderConfirmation.jsp").forward(request, response);
    }



}
