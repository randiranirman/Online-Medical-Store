<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.example.onlinemediclestore.Classes.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin - View All Orders</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<div class="container mx-auto px-4 py-8">
    <h1 class="text-3xl font-bold text-center text-gray-800 mb-8">Order Management</h1>

    <div class="bg-white rounded-lg shadow-md overflow-hidden">
        <%
            List<Order> orderList = (List<Order>) request.getAttribute("orderlist");
            if(orderList != null && !orderList.isEmpty()) {
                DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd MMM  YYYY HH:mm");
        %>
        <div class="overflow-x-auto">
            <table class="min-w-full divide-y divide-gray-200">
                <thead class="bg-gray-50">
                <tr>
                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Order ID</th>
                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Customer Name</th>
                    <th scope="col" class="px   -6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Date</th>
                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Total Amount</th>
                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                    <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
                </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                <% for(Order order : orderList) { %>
                <tr class="hover:bg-gray-50">
                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><%= order.getId() %></td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><%= order.getFullName() %></td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                        <%= order.getOrderDate() != null ? order.getOrderDate().format(formatter) : "N/A" %>
                    </td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">₹<%= String.format("%.2f", order.getTotalPrice()) %></td>
                    <td class="px-6 py-4 whitespace-nowrap">
                        <%
                            String statusColor = "gray";
                            String status = order.getStatus();
                            if(status != null) {
                                if(status.equalsIgnoreCase("pending")) {
                                    statusColor = "yellow";
                                } else if(status.equalsIgnoreCase("shipped")) {
                                    statusColor = "blue";
                                } else if(status.equalsIgnoreCase("delivered")) {
                                    statusColor = "green";
                                } else if(status.equalsIgnoreCase("cancelled")) {
                                    statusColor = "red";
                                }
                            }
                        %>
                        <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-<%= statusColor %>-100 text-<%= statusColor %>-800">
                                        <%= status != null ? status : "Unknown" %>
                                    </span>
                    </td>
                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium">
                        <div class="flex space-x-2">
                            <a href="editOrder?id=<%= order.getId() %>" class="text-indigo-600 hover:text-indigo-900">
                                <i class="fas fa-edit"></i> Edit
                            </a>



                            <form action="./delete" method="post" onsubmit="return confirm('Are you sure you want to delete this order?');">
                                <input type="hidden" name="orderId" value="<%= order.getId() %>">
                                <button type="submit"  class="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded text-sm">
                                    <input type="hidden"  name="type" value="order">
                                    <input type="hidden" name="orderID" value="<%= order.getId() %>"/>
                                    <i class="fas fa-trash-alt">Delete</i>
                                </button>
                            </form>
                        </div>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <% } else { %>
        <div class="py-8 text-center text-gray-500 italic">
            No orders found in the system.
        </div>
        <% } %>
    </div>
</div>

<script>
    function confirmDelete(orderId) {
        if(confirm("Are you sure you want to delete Order #" + orderId + "? This action cannot be undone.")) {
            window.location.href = "deleteOrder?id=" + orderId;
        }
    }
</script>
</body>
</html>