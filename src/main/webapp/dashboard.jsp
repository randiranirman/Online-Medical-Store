<%@ page import="org.example.onlinemediclestore.Classes.User" %>
<%@ page import="org.example.onlinemediclestore.Classes.Medicine" %>
<%@ page import="java.util.List" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("dashboard.jsp");
        return;
    }
    var medicine  = (Medicine) session.getAttribute("medicine");

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

    <div class="justify-between items-center">

        <a href="${pageContext.request.contextPath}//viewCustomerOrder" class="text-md cursor-pointer  font-semibold  text-blue-600 px-2 ">View Orders</a>
        <span class="text-gray-700">Hi, <%= user.getUsername() %> 👋</span>
    </div>
</nav>

<!-- Products Section -->
<div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-10">
    <h2 class="text-2xl font-semibold text-gray-800 mb-6">Featured Products</h2>

    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
        <%
            List<Medicine> medicines = (List<Medicine>) request.getAttribute("medicines");
            if (medicines != null) {
                for (Medicine med : medicines) {
        %>
        <div class="bg-white rounded-2xl shadow hover:shadow-lg transition-all duration-300 overflow-hidden">
            <img src="<%= request.getContextPath() + "/uploads/" + med.getImg_path() %>"
                 alt="<%= med.getName() %>" class="w-full h-48 object-cover">
            <div class="p-4">
                <h3 class="text-lg font-semibold text-gray-800"><%= med.getName() %></h3>
                <p class="text-sm text-gray-600"><%= med.getDescription() %></p>
                <p class="text-blue-600 font-bold mt-2">₹<%= med.getPrice() %></p>
                <a href="${pageContext.request.contextPath}/showProductDetails?medicineId=<%= med.getId() %>" class="px-4 w-full rounded-lg py-2 mt-2 bg-blue-700 text-white">View Product</a>
            </div>
        </div>
        <%
            }
        } else {
        %>
        <p>No medicines found.</p>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
