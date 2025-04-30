<%@ page import="org.example.onlinemediclestore.Classes.Medicine" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    List<Medicine> medicineList = (List<Medicine>) request.getAttribute("medicineList");
%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Add Medicine - Medicare</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 text-gray-800 font-sans">

<!-- Navbar -->
<nav class="bg-white shadow-md">
    <div class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
        <h1 class="text-2xl font-bold text-blue-600">Medicare</h1>
        <div>
            <a href="/" class="text-gray-600 hover:text-blue-500 px-4">Home</a>
            <a href="/medicines" class="text-gray-600 hover:text-blue-500 px-4">Medicines</a>
        </div>
    </div>
</nav>

<!-- Page Header -->
<div class="max-w-4xl mx-auto mt-10 text-center">
    <h2 class="text-3xl font-semibold text-gray-700 mb-4">Add New Medicine</h2>
    <p class="text-gray-500">Enter the details of the new medicine to be listed in the store.</p>
</div>

<!-- Form Section -->
<div class="max-w-2xl mx-auto mt-8 bg-white p-8 rounded-lg shadow-lg">
    <form action="./addMedicine" method="post" enctype="multipart/form-data" class="space-y-6">

        <div>
            <label class="block mb-1 font-medium text-gray-700">Medicine Name</label>
            <input type="text" name="name" placeholder="Enter medicine name" required
                   class="w-full border border-gray-300 p-3 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>

        <div>
            <label class="block mb-1 font-medium text-gray-700">Description</label>
            <input type="text" name="description" placeholder="Short description" required
                   class="w-full border border-gray-300 p-3 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>

        <div>
            <label class="block mb-1 font-medium text-gray-700">Price ($)</label>
            <input type="number" name="price" step="0.01" placeholder="e.g. 19.99" required
                   class="w-full border border-gray-300 p-3 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>
        <div>
            <label class="block mb-1 font-medium text-gray-700">Quantity</label>
            <input type="number" name="quantity" placeholder="Enter the quantity" required
                   class="w-full border border-gray-300 p-3 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>

        <div>
            <label class="block mb-1 font-medium text-gray-700">Upload Image</label>
            <input type="file" name="image" accept="image/*" required
                   class="w-full border border-gray-300 p-2 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>
        <div>
            <label class="block mb-1 font-medium text-gray-700">Supplier Name</label>
            <input type="text" name="supplierName"  required
                   class="w-full border border-gray-300 p-2 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>

        <div class="text-center">
            <button type="submit"
                    class="bg-blue-600 text-white px-6 py-3 rounded-md hover:bg-blue-700 transition duration-300">
                Add Medicine
            </button>
        </div>
    </form>
    <% String successMessage = (String) request.getAttribute("successMessage"); %>
    <% if (successMessage != null) { %>
    <div class="mt-4 p-3 bg-green-100 text-green-700 rounded-md">
        <%= successMessage %>
    </div>
    <% } %>
</div>

<div class="max-w-6xl mx-auto mt-10 text-center">
    <h2 class="text-3xl font-semibold text-gray-700 mb-2">Available Medicines</h2>
    <p class="text-gray-500 mb-6">Browse the medicines listed in our store.</p>

    <!-- Medicines Table -->
    <div class="overflow-x-auto">
        <table class="min-w-full bg-white border border-gray-200 shadow-md rounded-lg overflow-hidden">
            <thead class="bg-gray-100">
            <tr>
                <th class="px-4 py-3 text-left text-gray-700 font-semibold border-b">Image</th>
                <th class="px-4 py-3 text-left text-gray-700 font-semibold border-b">Name</th>
                <th class="px-4 py-3 text-left text-gray-700 font-semibold border-b">Description</th>
                <th class="px-4 py-3 text-left text-gray-700 font-semibold border-b">Price (₹)</th>
                <th class="px-4 py-3 text-left text-gray-700 font-semibold border-b">Quantity</th>
                <th class="px-4 py-3 text-left text-gray-700 font-semibold border-b">Supplier</th>
                <th class="px-4 py-3 text-left text-gray-700 font-semibold border-b">Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                String absolutePath = "C:\\Users\\binad\\Downloads\\apache-tomcat-10.1.39\\apache-tomcat-10.1.39\\bin\\medicare\\uploads";
                if (medicineList != null && !medicineList.isEmpty()) {
                    for (Medicine med : medicineList) {
            %>
            <tr class="hover:bg-gray-50">
                <td class="px-4 py-3 border-b">
                    <img src="<%=  med.getImg_path() != null ?      "./uploads/" + med.getImg_path() : "/images/default.jpg" %>"
                         alt="<%= med.getName() %>" class="w-16 h-16 object-cover rounded">
                </td>
                <td class="px-4 py-3 border-b font-medium text-blue-600"><%= med.getName() %></td>
                <td class="px-4 py-3 border-b text-gray-600"><%= med.getDescription() %></td>
                <td class="px-4 py-3 border-b"><%= med.getPrice() %></td>
                <td class="px-4 py-3 border-b"><%= med.getQuantity() %></td>
                <td class="px-4 py-3 border-b"><%= med.getSupplier() != null ? med.getSupplier().getUsername() : "N/A" %></td>
                <td class="px-4 py-3 border-b">
                    <form action="./delete" method="post" onsubmit="return confirm('Are you sure you want to delete this medicine?');">
                        <input type="hidden" name="medicineId" value="<%= med.getId() %>">
                        <button type="submit" class="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded text-sm">
                            <input type="hidden"  name="type" value="medicine">
                            <input type="hidden" name="medicineID" value="<%= med.getId() %>"/>
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
                <td colspan="7" class="px-4 py-6 text-center text-gray-500">No medicines available.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>

<!-- Footer -->
<footer class="mt-16 bg-white shadow-inner py-4 text-center text-gray-500 text-sm">
    &copy; 2025 Medicare. All rights reserved.
</footer>

</body>
</html>