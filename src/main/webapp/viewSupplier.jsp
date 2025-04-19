<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.onlinemediclestore.Classes.Supplier" %>
<%@ page import="java.util.List" %>
<%
    List<Supplier> suppliers = (List<Supplier>) request.getAttribute("suppliers");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Suppliers</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">

<div class="container mx-auto">
    <h1 class="text-3xl font-bold mb-6 text-center text-blue-700">Supplier Management</h1>
    <a  href="./admin.jsp" class="text-blue-500 mb-4 font-semibold"> <- Go to dashboard</a>

    <!-- Add Supplier Form -->
    <div class="bg-white p-6 rounded shadow-md mb-8">
        <h2 class="text-xl font-semibold mb-4 text-gray-700">Add New Supplier</h2>
        <form action="./supplier" method="post" class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <input type="text" name="name" placeholder="Full Name" required
                   class="border p-2 rounded w-full" />
            <input type="text" name="username" placeholder="Username" required
                   class="border p-2 rounded w-full" />
            <input type="email" name="email" placeholder="Email" required
                   class="border p-2 rounded w-full" />
            <input type="password" name="password" placeholder="Password" required
                   class="border p-2 rounded w-full" />
            <input type="text" name="companyName" placeholder="Company Name" required
                   class="border p-2 rounded w-full" />
            <input type="text" name="address" placeholder="Address" required
                   class="border p-2 rounded w-full" />
            <div class="md:col-span-2">
                <button type="submit"
                        class="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700 transition duration-200 w-full">
                    Add Supplier
                </button>
            </div>
        </form>
    </div>

    <!-- Suppliers Table -->
    <div class="bg-white p-6 rounded shadow-md">
        <h2 class="text-xl font-semibold mb-4 text-gray-700">All Suppliers</h2>
        <table class="min-w-full border-collapse border border-gray-300">
            <thead class="bg-blue-100">
            <tr>
                <th class="border border-gray-300 px-4 py-2">Name</th>
                <th class="border border-gray-300 px-4 py-2">Username</th>
                <th class="border border-gray-300 px-4 py-2">Email</th>
                <th class="border border-gray-300 px-4 py-2">Company</th>
                <th class="border border-gray-300 px-4 py-2">Address</th>
                <th class="border border-gray-300 px-4 py-2">Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (suppliers != null && !suppliers.isEmpty()) {
                    for (Supplier supplier : suppliers) {
            %>
            <tr class="bg-gray-50 hover:bg-gray-100">
                <td class="border border-gray-300 px-4 py-2"><%= supplier.getName() %></td>
                <td class="border border-gray-300 px-4 py-2"><%= supplier.getUsername() %></td>
                <td class="border border-gray-300 px-4 py-2"><%= supplier.getEmail() %></td>
                <td class="border border-gray-300 px-4 py-2"><%= supplier.getCompanyName() %></td>
                <td class="border border-gray-300 px-4 py-2"><%= supplier.getAddress() %></td>
                <td class="border border-gray-300 px-4 py-2">
                    <form method="post" action="./delete"   onsubmit="return confirm('Are you sure you want to delete this user?');" style="display:inline;">
                        <input type="hidden" name="username" value="<%= supplier.getUsername() %>"/>
                        <input type="hidden" name="type" value="supplier">
                        <button type="submit" class="text-red-600 hover:text-red-800 font-semibold">
                            Delete
                        </button>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="5" class="text-center py-4 text-gray-500">No suppliers found.</td>
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
