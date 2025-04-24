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
    <a href="./index.jsp"  class="text-xl font-bold text-blue-600">Medicare Dashboard</a>
    <span class="text-gray-700">Hi, <%= user.getUsername() %> 👋</span>
</nav>


</body>
</html>
