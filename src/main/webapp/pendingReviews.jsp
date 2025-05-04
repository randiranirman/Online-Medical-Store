<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.onlinemediclestore.Classes.Review" %>
<%@ page import="org.example.onlinemediclestore.Classes.User" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pending Reviews</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen font-sans">
<div class="container mx-auto px-4 py-8">
    <h1 class="text-3xl font-bold text-center text-indigo-700 mb-8">Pending Reviews</h1>

    <div class="bg-white shadow-md rounded-lg overflow-hidden">
        <table class="min-w-full table-auto text-sm text-left">
            <thead class="bg-indigo-600 text-white">
            <tr>
                <th class="px-6 py-3">Review ID</th>
                <th class="px-6 py-3">User</th>
                <th class="px-6 py-3">Medicine</th>
                <th class="px-6 py-3">Review</th>
                <th class="px-6 py-3">Actions</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <%
                List<Review> reviews = (List<Review>) request.getAttribute("pendingReviews");
                if (reviews != null && !reviews.isEmpty()) {
                    for (Review review : reviews) {
            %>
            <tr>
                <td class="px-6 py-4"><%= review.getId() %></td>
                <td class="px-6 py-4"><%= review.getUserId() %></td>
                <td class="px-6 py-4"><%= review.getProductId() %></td>
                <td class="px-6 py-4"><%= review.getContent() %></td>
                <td class="px-6 py-4 flex space-x-2">
                    <form action="<%=request.getContextPath()%>/approveReview" method="post">
                        <input type="hidden" name="reviewId" value="<%= review.getId() %>">
                        <button type="submit" class="bg-green-500 hover:bg-green-600 text-white px-3 py-1 rounded-md">Approve</button>
                    </form>
                    <form action="<%=request.getContextPath()%>/deleteReview" method="post">
                        <input type="hidden" name="reviewId" value="<%= review.getId() %>">
                        <button type="submit" class="bg-red-500 hover:bg-red-600 text-white px-3 py-1 rounded-md">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="5" class="text-center py-4 text-gray-500">No pending reviews found.</td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
