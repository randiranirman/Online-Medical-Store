<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medicine Details</title>
    <!-- Use a reliable link for Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 font-sans leading-normal tracking-normal">

<div class="container mx-auto px-4 py-8">
    <h1 class="text-3xl font-bold mb-6 text-center text-indigo-700">Medicine Details</h1>

    <%
        org.example.onlinemediclestore.Classes.Medicine medicine =
                (org.example.onlinemediclestore.Classes.Medicine) request.getAttribute("medicine");

        if (medicine != null) {
    %>

    <div class="max-w-4xl mx-auto bg-white rounded-lg shadow-md flex flex-col md:flex-row">
        <div class="md:w-1/2">
            <img class="w-full h-full object-cover" src="<%= request.getContextPath() + "/uploads/" + medicine.getImg_path() %>" alt="<%= medicine.getName() %>">
        </div>
        <div class="p-6 md:w-1/2">
            <h2 class="text-2xl font-semibold text-gray-800 mb-2"><%= medicine.getName() %></h2>
            <p class="text-gray-600 mb-4"><%= medicine.getDescription() %></p>
            <p class="text-xl font-bold text-indigo-600 mb-4">Price: $<%= medicine.getPrice() %></p>

            <!-- Order Form -->
            <form action="<%= request.getContextPath() %>/orderProcessing" method="post" class="mb-6">
                <input type="hidden" name="medicineId" value="<%= medicine.getId() %>">
                <label for="quantity" class="block text-sm font-medium text-gray-700">Quantity:</label>
                <input type="number" id="quantity" name="quantity" min="1" value="1" required
                       class="mt-1 mb-4 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
                <!-- Simple Address Section -->
                <div class="mt-6 space-y-3">
                    <h3 class="text-lg font-medium text-gray-800">Delivery Address</h3>

                    <div>
                        <label for="fullName" class="block text-sm font-medium text-gray-700">Full Name</label>
                        <input type="text" name="fullName" id="fullName" required
                               class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500">
                    </div>

                    <div>
                        <label for="phone" class="block text-sm font-medium text-gray-700">Phone Number</label>
                        <input type="tel" name="phone" id="phone" required
                               class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500">
                    </div>

                    <div>
                        <label for="address" class="block text-sm font-medium text-gray-700">Address</label>
                        <textarea name="address" id="address" rows="3" required
                                  class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500"></textarea>
                    </div>
                </div>
                <button type="submit"
                        class="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-bold py-2 px-4 rounded">
                    Place Order
                </button>
            </form>

            <!-- Review Form -->
            <form action="<%= request.getContextPath() %>/submitReviews" method="post">
                <input type="hidden" name="productId" value="<%= medicine.getId() %>">
                <h3 class="text-lg font-semibold text-gray-800 mb-2">Leave a Review</h3>

                <label for="rating" class="block text-sm font-medium text-gray-700">Rating (1-5):</label>
                <input type="number" id="rating" name="rating" min="1" max="5" required
                       class="mt-1 mb-4 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">

                <label for="content" class="block text-sm font-medium text-gray-700">Your Review:</label>
                <textarea id="content" name="content" rows="4" required
                          class="mt-1 mb-4 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"></textarea>

                <button type="submit"
                        class="w-full bg-green-600 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">
                    Submit Review
                </button>
            </form>
        </div>
    </div>

    <% } else { %>
    <p class="text-center text-red-600">Medicine not found.</p>
    <% } %>

</div>
</body>
</html>
