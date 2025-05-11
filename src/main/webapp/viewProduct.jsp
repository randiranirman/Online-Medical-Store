<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medicine Details</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans leading-normal tracking-normal">

<div class="container mx-auto px-4 py-8">
    <h1 class="text-3xl font-bold mb-6 text-center text-indigo-700">Medicine Details</h1>

    <%
        org.example.onlinemediclestore.Classes.Medicine medicine =
                (org.example.onlinemediclestore.Classes.Medicine) request.getAttribute("medicine");

        if (medicine != null) {
    %>

    <div class="max-w-4xl mx-auto bg-white rounded-lg shadow-md overflow-hidden flex flex-col md:flex-row">
        <div class="md:w-1/2">
            <img class="w-full h-full object-cover" src="<%= request.getContextPath() + "/uploads/" + medicine.getImg_path() %>" alt="<%= medicine.getName() %>">
        </div>
        <div class="p-6 md:w-1/2">
            <h2 class="text-2xl font-semibold text-gray-800 mb-2"><%= medicine.getName() %></h2>
            <p class="text-gray-600 mb-4"><%= medicine.getDescription() %></p>
            <p class="text-xl font-bold text-indigo-600 mb-4">Price: $<%= medicine.getPrice() %></p>

            <form action="./orderProcessing" method="post" class="space-y-4">
                <input type="hidden" name="medicineId" value="<%= medicine.getId() %>">

                <div>
                    <label for="quantity" class="block font-medium text-gray-700 mb-1">Quantity:</label>
                    <select name="quantity" id="quantity" class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-indigo-500">
                        <% for (int i = 1; i <= 10; i++) { %>
                        <option value="<%= i %>"><%= i %></option>
                        <% } %>
                    </select>
                </div>




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
                        class="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-semibold py-2 px-4 rounded-md transition duration-200 mt-4">
                    Place Order
                </button>
            </form>

            <!-- Review Form -->
            <div class="mt-8 border-t pt-6">
                <h3 class="text-xl font-bold text-indigo-700 mb-4">Leave a Review</h3>
                <form action="./addProductReview" method="post" class="space-y-4">
                    <!-- Hidden fields -->
                    <input type="hidden" name="medicineId" value="<%= medicine.getId() %>">
                    <input type="hidden" name="medicineName" value="<%= medicine.getName() %>">
                    <input type="hidden" name="userId" value="<%= session.getAttribute("user") %>">
                    <input type="hidden" name="userName" value="<%= session.getAttribute("userName") %>">

                    <div>
                        <label for="rating" class="block text-gray-700 font-medium">Rating</label>
                        <select id="rating" name="rating" required class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500">
                            <option value="">-- Select a rating --</option>
                            <% for (int i = 1; i <= 5; i++) { %>
                            <option value="<%= i %>"><%= i %> Star<%= (i > 1) ? "s" : "" %></option>
                            <% } %>
                        </select>
                    </div>

                    <div>
                        <label for="comments" class="block text-gray-700 font-medium">Comments</label>
                        <textarea id="comments" name="comments" rows="4" required
                                  class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                                  placeholder="Write your experience..."></textarea>
                    </div>

                    <div>
                        <button type="submit"
                                class="bg-indigo-600 text-white px-6 py-2 rounded-md hover:bg-indigo-700 transition">
                            Submit Review
                        </button>
                    </div>
                </form>
            </div>
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