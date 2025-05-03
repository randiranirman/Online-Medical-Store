package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.onlinemediclestore.Classes.Customer;
import org.example.onlinemediclestore.Classes.Order;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/viewCustomerOrder")
public class ViewCustomerOrder extends HttpServlet {

    private final String FILEPATH = Config.ORDERS.getPath();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        Customer currentUser = (Customer) session.getAttribute("user");

        if (currentUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String userId = currentUser.getUserID();

        GenericCRUD<Order> orderCRUD = new GenericCRUD<>(Order.class, FILEPATH);
        List<Order> allOrders = orderCRUD.readAll();

        List<Order> customerOrders = new ArrayList<>();

        for (Order order : allOrders) {
            if (userId.equals(order.getUserID())) {
                customerOrders.add(order);
            }
        }

        request.setAttribute("orders", customerOrders);
        request.getRequestDispatcher("viewCustomerOrder.jsp").forward(request, response);
    }

    protected  void doPost( HttpServletRequest request, HttpServletResponse response)throws  IOException, ServletException{

             doGet(request, response);
    }
}
