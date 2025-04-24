<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.onlinemediclestore.Classes.Admin" %>
<%@ page import="java.util.List" %>
<%
    List<Admin> admins = (List<Admin>) request.getAttribute("admins");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Management</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">

<div class="container mx-auto">
    <h1 class="text-3xl font-bold mb-6 text-center text-blue-700">Admin Management</h1>
    <a href="./admin.jsp" class="text-blue-500 mb-4 font-semibold">← Go to dashboard</a>

    <!-- Error Message -->
    <%
        if (error != null) {
    %>
    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
        <%= error %>
    </div>
    <%
        }
    %>

    <!-- Admin Creation Form -->
    <div class="bg-white p-6 rounded shadow-md mb-6">
        <form method="post" action="./admin-creation" class="space-y-4">
            <div>
                <label class="block font-medium">Name</label>
                <input type="text" name="name" required class="w-full border p-2 rounded" />
            </div>
            <div>
                <label class="block font-medium">Username</label>
                <input type="text" name="username" required class="w-full border p-2 rounded" />
            </div>
            <div>
                <label class="block font-medium">Password</label>
                <input type="password" name="password" required class="w-full border p-2 rounded" />
            </div>
            <div>
                <label class="block font-medium">Email</label>
                <input type="email" name="email" required class="w-full border p-2 rounded" />
            </div>
            <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
                Create Admin
            </button>
        </form>
    </div>

    <!-- Admin Table -->
    <div class="bg-white p-6 rounded shadow-md">
        <table class="min-w-full table-auto">
            <thead>
            <tr class="bg-blue-100">
                <th class="px-4 py-2 text-left">Name</th>
                <th class="px-4 py-2 text-left">Username</th>
                <th class="px-4 py-2 text-left">Email</th>
                <th class="px-4 py-2 text-left">Role</th>
                <th class="px-4 py-2  text-left">Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (admins != null && !admins.isEmpty()) {
                    for (Admin admin : admins) {
            %>
            <tr class="border-b hover:bg-gray-50">
                <td class="px-4 py-2"><%= admin.getName() %></td>
                <td class="px-4 py-2"><%= admin.getUsername() %></td>
                <td class="px-4 py-2"><%= admin.getEmail() %></td>
                <td class="px-4 py-2"><%= admin.getRole() %></td>
                <td class="px-4 py-2">

                    <form action="./delete" method="post" class="justify-center"   >
                        <input type="hidden" name="username" value="<%= admin.getUsername() %>"/>

                        <input type="hidden"  name="type" value="admin">

                        <button class="px-2 py-2  text-white font-semibold rounded-lg bg-red-500" type="submit">Delete</button>


                    </form>


                </td>

            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="4" class="text-center py-4">No admins found.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
