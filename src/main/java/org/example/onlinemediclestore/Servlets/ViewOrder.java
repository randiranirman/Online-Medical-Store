package org.example.onlinemediclestore.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.onlinemediclestore.Classes.Order;
import org.example.onlinemediclestore.FileConfig.Config;
import org.example.onlinemediclestore.utils.GenericCRUD;

import java.io.IOException;
import java.util.List;


@WebServlet("/viewOrder")
public class ViewOrder extends HttpServlet {

    private final String ORDER_FILEPATH = Config.ORDERS.getPath();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        GenericCRUD<Order> orderGenericCRUD = new GenericCRUD<Order>(Order.class, ORDER_FILEPATH);
        List<Order> orderList = orderGenericCRUD.readAll();
        request.setAttribute("orderlist", orderList);
        request.getRequestDispatcher("viewOrder.jsp").forward(request, response);
    }
}