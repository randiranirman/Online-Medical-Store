<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Product</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans leading-normal tracking-normal">

<div class="container mx-auto px-4 py-10">
    <h1 class="text-3xl font-bold mb-6 text-center text-indigo-700">Medicine Details</h1>

    <%
        org.example.onlinemediclestore.Classes.Medicine medicine =
                (org.example.onlinemediclestore.Classes.Medicine) request.getAttribute("medicine");

        if (medicine != null) {
    %>

    <div class="max-w-3xl mx-auto bg-white rounded-2xl shadow-lg overflow-hidden flex flex-col md:flex-row">
        <div class="md:w-1/2">
            <img class="w-full h-full object-cover" src=<%= request.getContextPath() + "/uploads/" + medicine.getImg_path() %> git >
        </div>
        <div class="p-6 md:w-1/2">
            <h2 class="text-2xl font-semibold text-gray-800 mb-2"><%= medicine.getName() %></h2>
            <p class="text-gray-600 mb-4"><%= medicine.getDescription() %></p>
            <p class="text-xl font-bold text-indigo-600 mb-4">Price: $<%= medicine.getPrice() %></p>

            <form action="placeOrder" method="post" class="space-y-4">
                <input type="hidden" name="medicineId" value="<%= medicine.getId() %>">

                <label for="quantity" class="block font-medium text-gray-700">Quantity:</label>
                <select name="quantity" id="quantity" class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500">
                    <% for (int i = 1; i <= 10; i++) { %>
                    <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>

                <button type="submit"
                        class="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-semibold py-2 px-4 rounded-md transition duration-200">
                    Place Order
                </button>
            </form>
        </div>
    </div>

    <%
    } else {
    %>
    <p class="text-center text-red-600 font-semibold">No medicine data available.</p>
    <%
        }
    %>
</div>

</body>
</html>
