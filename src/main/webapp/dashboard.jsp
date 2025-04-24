<%@ page import="org.example.onlinemediclestore.Classes.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("dashboard.jsp");
        return;
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medicare | Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans leading-normal tracking-normal">

<!-- Navbar -->
<nav class="bg-white shadow-md px-6 py-4 flex justify-between items-center">
    <a href="./index.jsp" class="text-xl font-bold text-blue-600">Medicare Dashboard</a>
    <span class="text-gray-700">Hi, <%= user.getUsername() %> 👋</span>
</nav>

<!-- Products Section -->
<div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-10">
    <h2 class="text-2xl font-semibold text-gray-800 mb-6">Featured Products</h2>

    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
        <!-- Product Card Example -->
        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition-all duration-300 overflow-hidden">
            <img src="https://via.placeholder.com/300x200" alt="Product" class="w-full h-48 object-cover">
            <div class="p-4">
                <h3 class="text-lg font-semibold text-gray-800">Paracetamol 500mg</h3>
                <p class="text-gray-600 text-sm mb-2">Relieves pain and fever</p>
                <p class="text-blue-600 font-bold mb-4">₹50</p>
                <button class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition">Add to Cart</button>
            </div>
        </div>

        <!-- Copy and customize the product card above for more products -->
    </div>
</div>

</body>
</html>
