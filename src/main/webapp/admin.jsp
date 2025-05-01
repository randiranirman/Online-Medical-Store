<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans leading-normal tracking-normal">

<!-- Navbar -->
<nav class="bg-blue-800 p-4 shadow-lg">
    <div class="container mx-auto flex justify-between items-center">
        <span class="text-white text-2xl font-bold">Admin Dashboard</span>
        <div class="space-x-4">
            <a href="${pageContext.request.contextPath}/supplier" class="text-white hover:underline">View Suppliers</a>
            <a href="${pageContext.request.contextPath}/user" class="text-white hover:underline">View Users</a>
            <a href="${pageContext.request.contextPath}/addMedicine" class="text-white hover:underline">View Medicines</a>
            <a href="${pageContext.request.contextPath}/viewOrder" class="text-white hover:underline">View Orders</a>

            <a href="${pageContext.request.contextPath}/admin-creation" class="text-white hover:underline">View Admins</a>
        </div>
    </div>
</nav>

<!-- Dashboard content -->
<div class="container mx-auto mt-8 px-4">
    <h2 class="text-xl font-semibold mb-4">Welcome, Admin!</h2>

    <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
        <div class="bg-white p-6 rounded-xl shadow hover:shadow-md">
            <h3 class="text-lg font-medium">Suppliers</h3>
            <p class="text-sm text-gray-500 mt-1">Manage all registered suppliers.</p>
            <a href="viewSuppliers.jsp" class="mt-3 inline-block text-blue-600 hover:underline">View</a>
        </div>

        <div class="bg-white p-6 rounded-xl shadow hover:shadow-md">
            <h3 class="text-lg font-medium">Users</h3>
            <p class="text-sm text-gray-500 mt-1">Manage users and customers.</p>
            <a href="viewUsers.jsp" class="mt-3 inline-block text-blue-600 hover:underline">View</a>
        </div>

        <div class="bg-white p-6 rounded-xl shadow hover:shadow-md">
            <h3 class="text-lg font-medium">Medicines</h3>
            <p class="text-sm text-gray-500 mt-1">Manage medicines and inventory.</p>
            <a href="viewMedicines.jsp" class="mt-3 inline-block text-blue-600 hover:underline">View</a>
        </div>

        <div class="bg-white p-6 rounded-xl shadow hover:shadow-md">
            <h3 class="text-lg font-medium">Orders</h3>
            <p class="text-sm text-gray-500 mt-1">Manage customer orders and delivery.</p>
            <a href="viewOrders.jsp" class="mt-3 inline-block text-blue-600 hover:underline">View</a>
        </div>
    </div>
</div>

</body>
</html>
