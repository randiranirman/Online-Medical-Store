    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="org.example.onlinemediclestore.Classes.Customer" %>
    <%@ page import="java.util.List" %>
    <%
        List<Customer> userList = (List<Customer>) request.getAttribute("userList");
        String message = (String) request.getAttribute("message");
    %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>User Management</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body class="bg-gray-100 p-6">

    <div class="container mx-auto">
        <h1 class="text-3xl font-bold mb-6 text-center text-blue-700">User Management</h1>

        <!-- Message -->
        <% if (message != null) { %>
        <div class="bg-yellow-100 text-yellow-800 p-4 rounded mb-4 text-center">
            <%= message %>
        </div>
        <% } %>

        <% if (userList != null && !userList.isEmpty()) { %>
        <div class="bg-white p-6 rounded shadow-md overflow-x-auto">
            <table class="min-w-full divide-y divide-gray-200">
                <thead class="bg-blue-600 text-white">
                <tr>
                    <th class="px-6 py-3 text-left text-sm font-medium uppercase">Name</th>
                    <th class="px-6 py-3 text-left text-sm font-medium uppercase">Email</th>
                    <th class="px-6 py-3 text-left text-sm font-medium uppercase">Username</th>
                    <th class="px-6 py-3 text-left text-sm font-medium uppercase">Action</th>
                    <!-- Add more columns as needed -->
                </tr>
                </thead>
                <tbody class="divide-y divide-gray-300">
                <% for (Customer user : userList) { %>
                <tr class="hover:bg-gray-100">
                    <td class="px-6 py-4 text-sm text-gray-800"><%= user.getName() %></td>
                    <td class="px-6 py-4 text-sm text-gray-800"><%= user.getEmail() %></td>
                    <td class="px-6 py-4 text-sm text-gray-800"><%= user.getUsername() %></td>
                    <td class="px-6 py-4 text-sm text-gray-800">
                        <button  class="px-4 py-2 bg-blue-600 text-white rounded-lg ">Edit</button>
                            <button  class=" px-2 py-2 bg-red-600 text-white rounded-lg ">Delete</button>
                    </td>


                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <% } else { %>
        <div class="bg-yellow-100 text-yellow-800 p-4 rounded mb-4 text-center">
            No users found.
        </div>
        <% } %>
    </div>

    </body>
    </html>