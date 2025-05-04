<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.example.onlinemediclestore.Classes.Customer" %>
<%@ page import="org.example.onlinemediclestore.Classes.Supplier" %>
<%@ page import="org.example.onlinemediclestore.Classes.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen">
<%
    // Get user from session
    User userObj = (User) session.getAttribute("user");
    String role = userObj.getRole();

    if (userObj == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    String username = "";
    String name = "";
    String email = "";
    String id = "";
    String companyName = "";
    String address = "";

    if (role.equals("customer")) {
        Customer customer = (Customer) userObj;
        username = customer.getUsername();
        name = customer.getName();
        email = customer.getEmail();
        id = customer.getUserID();
    } else if (role.equals("supplier")) {
        Supplier supplier = (Supplier) userObj;
        username = supplier.getUsername();
        name = supplier.getName();
        email = supplier.getEmail();
        id = supplier.getUserID();
        companyName = supplier.getCompanyName();
        address = supplier.getAddress();
    }
%>

<div class="container mx-auto px-4 py-8">
    <div class="max-w-lg mx-auto bg-white rounded-lg shadow-md overflow-hidden">
        <div class="bg-blue-600 text-white px-6 py-4">
            <h1 class="text-2xl font-bold">Edit Profile</h1>
        </div>

        <div class="p-6">
            <form action="..//editUser" method="post" class="space-y-4">
                <input type="hidden" name="username" value="<%= username %>">
                <input type="hidden" name="id" value="<%= id %>">
                <input type="hidden" name="type" value="<%= role %>">

                <div>
                    <label for="updatedName" class="block text-sm font-medium text-gray-700">Name</label>
                    <input type="text" id="updatedName" name="updatedName" value="<%= name %>" required
                           class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
                </div>

                <div>
                    <label for="updatedUsername" class="block text-sm font-medium text-gray-700">Username</label>
                    <input type="text" id="updatedUsername" name="updatedUsername" value="<%= username %>" required
                           class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
                </div>

                <div>
                    <label for="updatedEmail" class="block text-sm font-medium text-gray-700">Email</label>
                    <input type="email" id="updatedEmail" name="updatedEmail" value="<%= email %>" required
                           class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
                </div>

                <% if (role.equals("supplier")) { %>
                <div>
                    <label for="updateCompanyName" class="block text-sm font-medium text-gray-700">Company Name</label>
                    <input type="text" id="updateCompanyName" name="updateCompanyName" value="<%= companyName %>" required
                           class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
                </div>

                <div>
                    <label for="updatedAddress" class="block text-sm font-medium text-gray-700">Address</label>
                    <textarea id="updatedAddress" name="updatedAddress" rows="3" required
                              class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500"><%= address %></textarea>
                </div>
                <% } %>

                <div class="flex items-center justify-between pt-4">
                    <button type="submit" class="px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">
                        Update Profile
                    </button>

                    <a href="<%= request.getContextPath() %>/<%= role.equals("customer") ? "showProducts" : "supplier.jsp" %>"
                       class="px-4 py-2 bg-gray-300 text-gray-700 rounded-md hover:bg-gray-400 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2">
                        Cancel
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>