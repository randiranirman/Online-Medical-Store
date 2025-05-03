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
<body class="bg-gradient-to-b from-blue-50 to-white min-h-screen p-6 font-sans">
<div class="max-w-4xl mx-auto">
    <div class="flex justify-between items-center mb-6">
        <h1 class="text-3xl font-extrabold text-blue-700">My Orders</h1>
        <a href="${pageContext.request.contextPath}//showProducts" class="text-white bg-blue-600 hover:bg-blue-700 transition px-4 py-2 rounded-lg shadow-sm text-sm font-medium">
            Go to Dashboard
        </a>
    </div>

    <%
        List<Order> orders = (List<Order>) request.getAttribute("orders");
        if (orders == null || orders.isEmpty()) {
    %>
    <div class="text-center text-gray-500 text-lg">No orders found.</div>
    <%
    } else {
        for (Order order : orders) {
    %>
    <div class="bg-white shadow-md rounded-lg p-5 mb-5 transition-transform transform hover:scale-[1.01]">
        <div class="flex items-center justify-between mb-2">
            <h2 class="text-lg font-semibold text-gray-800">Order #<%= order.getId() %></h2>
            <span class="text-sm px-3 py-1 rounded-full
                         <% if ("Completed".equalsIgnoreCase(order.getStatus())) { %>
                             bg-green-100 text-green-700
                         <% } else if ("Pending".equalsIgnoreCase(order.getStatus())) { %>
                             bg-yellow-100 text-yellow-700
                         <% } else { %>
                             bg-gray-100 text-gray-700
                         <% } %>">
                <%= order.getStatus() %>
            </span>
        </div>
        <p class="text-sm text-gray-500 mb-1"><strong>Date:</strong> <%= order.getOrderDate() %></p>
        <!-- Add more fields like total price, items, etc. -->
        <!-- Example: -->
        <!-- <p class="text-sm text-gray-500"><strong>Total:</strong> $<%= order.getTotalPrice() %></p> -->
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
