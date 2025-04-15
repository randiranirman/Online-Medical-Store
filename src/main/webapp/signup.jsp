<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Sign Up - Medicare</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        /* Custom styling for the background and form layout */
        .background-gradient {
            background: linear-gradient(135deg, #6EE7B7, #3B82F6);
        }
    </style>
</head>

<body class="background-gradient text-gray-800 font-sans">

<!-- Navbar -->
<nav class="bg-white shadow-md">
    <div class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
        <h1 class="text-2xl font-bold text-blue-600">Medicare</h1>
        <ul class="flex space-x-6 text-sm font-medium">
            <li><a href="index.jsp" class="hover:text-blue-600 transition">Home</a></li>
            <li><a href="#" class="hover:text-blue-600 transition">Medicines</a></li>
            <li><a href="#" class="hover:text-blue-600 transition">Contact</a></li>
            <li><a href="login.jsp" class="hover:text-blue-600 transition">Login</a></li>
        </ul>
    </div>
</nav>

<!-- Sign Up Form -->
<div class="flex items-center justify-center min-h-screen px-4">
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4">
        <strong class="font-bold">Error:</strong>
        <span class="block sm:inline"><%= error %></span>
    </div>
    <% } %>
    <form action="./signup" method="post" class="bg-white shadow-md rounded-lg p-8 w-full max-w-md">
        <h2 class="text-2xl font-bold text-center text-blue-600 mb-6">Create Your Account</h2>

        <!-- Full Name -->
        <div class="mb-4">
            <label class="block text-sm font-semibold mb-1">Full Name</label>
            <input type="text" name="name" required class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-300">
        </div>

        <!-- Username -->
        <div class="mb-4">
            <label class="block text-sm font-semibold mb-1">Username</label>
            <input type="text" name="username" required class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-300">
        </div>

        <!-- Email -->
        <div class="mb-4">
            <label class="block text-sm font-semibold mb-1">Email</label>
            <input type="email" name="email" required class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-300">
        </div>

        <!-- Password -->
        <div class="mb-4">
            <label class="block text-sm font-semibold mb-1">Password</label>
            <input type="password" name="password" required class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-300">
        </div>

        <!-- Confirm Password -->
        <div class="mb-6">
            <label class="block text-sm font-semibold mb-1">Confirm Password</label>
            <input type="password" name="confirmPassword" required class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-300">
        </div>

        <!-- Submit Button -->
        <button type="submit" class="w-full bg-blue-600 text-white py-2 rounded-lg font-semibold hover:bg-blue-700 transition">
            Sign Up
        </button>

        <!-- Link to Login -->
        <p class="text-sm text-center mt-4">
            Already have an account?
            <a href="login.jsp" class="text-blue-600 hover:underline">Login</a>
        </p>
    </form>
</div>

</body>

</html>
