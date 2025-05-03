<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.onlinemediclestore.Classes.Order" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Orders</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">
<div class="max-w-4xl mx-auto bg-white rounded-lg shadow-md p-6">
    <h1 class="text-2xl font-bold text-blue-600 mb-4">My Orders</h1>

    <%
        List<Order> orders = (List<Order>) request.getAttribute("orders");
        if (orders == null || orders.isEmpty()) {
    %>
    <div class="text-gray-500">No orders found.</div>
    <%
    } else {
        for (Order order : orders) {
    %>
    <div class="border-b border-gray-200 py-4">
        <p><strong>Order ID:</strong> <%= order.getId() %></p>
        <p><strong>Date:</strong> <%= order.getOrderDate() %></p>
        <p><strong>Status:</strong> <%= order.getStatus() %></p>
        <!-- You can add more order fields as needed -->
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
