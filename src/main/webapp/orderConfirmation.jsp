<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans leading-normal tracking-normal">

<div class="container mx-auto px-4 py-10">
    <h1 class="text-3xl font-bold mb-6 text-center text-indigo-700">Order Confirmation</h1>

    <%
        org.example.onlinemediclestore.Classes.Order order =
                (org.example.onlinemediclestore.Classes.Order) request.getAttribute("order");

        if (order != null) {
    %>

    <div class="max-w-3xl mx-auto bg-white rounded-2xl shadow-lg overflow-hidden p-8">
        <div class="flex justify-between items-center mb-6 pb-4 border-b border-gray-200">
            <div>
                <h2 class="text-2xl font-semibold text-gray-800">Thank You for Your Order!</h2>
                <p class="text-gray-600">Your order has been successfully placed.</p>
            </div>
            <div class="bg-green-100 text-green-800 px-4 py-2 rounded-full font-medium text-sm">
                <%= order.getStatus() %>
            </div>
        </div>

        <div class="mb-6">
            <h3 class="text-lg font-medium text-gray-800 mb-2">Order Details</h3>
            <div class="bg-gray-50 p-4 rounded-lg">
                <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div>
                        <p class="text-sm text-gray-600">Order ID:</p>
                        <p class="font-medium"><%= order.getId() %></p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Order Date:</p>
                        <p class="font-medium"><%= order.getOrderDate() %></p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Status:</p>
                        <p class="font-medium"><%= order.getStatus() %></p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Total Amount:</p>
                        <p class="font-medium text-indigo-600">$<%= order.getTotalPrice() %></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="mb-6">
            <h3 class="text-lg font-medium text-gray-800 mb-2">Product Information</h3>
            <div class="bg-gray-50 p-4 rounded-lg flex items-center">
                <div class="w-16 h-16 mr-4">
                    <img class="w-full h-full object-cover rounded-md"
                         src="<%= request.getContextPath() + "/uploads/" + order.getMedicine().getImg_path() %>"
                         alt="<%= order.getMedicineName() %>">
                </div>
                <div class="flex-1">
                    <p class="font-medium text-gray-800"><%= order.getMedicineName() %></p>
                    <p class="text-sm text-gray-600">Quantity: <%= order.getQuantity() %></p>
                    <p class="text-sm text-gray-600">Price per unit: $<%= order.getMedicine().getPrice() %></p>
                </div>
            </div>
        </div>

        <div class="mb-6">
            <h3 class="text-lg font-medium text-gray-800 mb-2">Delivery Information</h3>
            <div class="bg-gray-50 p-4 rounded-lg">
                <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div>
                        <p class="text-sm text-gray-600">Full Name:</p>
                        <p class="font-medium"><%= order.getFullName() %></p>
                    </div>
                    <div>
                        <p class="text-sm text-gray-600">Phone Number:</p>
                        <p class="font-medium"><%= order.getPhoneNumber() %></p>
                    </div>
                    <div class="md:col-span-2">
                        <p class="text-sm text-gray-600">Delivery Address:</p>
                        <p class="font-medium"><%= order.getAddress() %></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="flex justify-center mt-8">
            <a href=".//showProducts" class="bg-indigo-600 hover:bg-indigo-700 text-white font-semibold py-2 px-6 rounded-md transition duration-200">
                Continue Shopping
            </a>
        </div>
    </div>

    <%
    } else {
    %>
    <div class="max-w-3xl mx-auto bg-white rounded-2xl shadow-lg overflow-hidden p-8 text-center">
        <p class="text-red-600 font-semibold mb-4">Order information not available.</p>
        <a href="viewMedicine" class="bg-indigo-600 hover:bg-indigo-700 text-white font-semibold py-2 px-4 rounded-md transition duration-200">
            Return to Products
        </a>
    </div>
    <%
        }
    %>
</div>

</body>
</html>