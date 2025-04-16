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

<!-- Top Navbar -->
<nav class="bg-white shadow-md px-6 py-4 flex justify-between items-center">
    <h1 class="text-xl font-bold text-blue-600">Medicare Dashboard</h1>
    <span class="text-gray-700">Hi, <%= user.getUsername() %> 👋</span>
</nav>

<!-- Main Content -->
<main class="p-6 max-w-5xl mx-auto">
    <div class="bg-white p-6 rounded-xl shadow-lg">
        <h2 class="text-2xl font-semibold text-gray-800 mb-4">User Details</h2>

        <div class="grid grid-cols-1 sm:grid-cols-2 gap-4 text-gray-700">
            <div>
                <span class="font-medium">Full Name:</span> <%= user.getName() %>
            </div>
            <div>
                <span class="font-medium">Username:</span> <%= user.getUsername() %>
            </div>
            <div>
                <span class="font-medium">Email:</span> <%= user.getEmail() %>
            </div>
            <div>
                <span class="font-medium">Role</span >
            </div>
        </div>
    </div>
</main>

</body>
</html>
