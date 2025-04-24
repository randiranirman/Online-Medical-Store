<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Medicare | Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        /* Custom styling for the background and form layout */
        .background-gradient {
            background: linear-gradient(135deg, #6EE7B7, #3B82F6);
        }
    </style>
</head>

<body class="background-gradient font-sans bg-gray-100 flex justify-center items-center min-h-screen">

<!-- Login Form Container -->
<div class="w-full max-w-md bg-white p-8 rounded-xl shadow-xl">

    <h2 class="text-3xl font-bold text-center text-blue-600 mb-6">Login to Your Account</h2>

    <!-- Form Starts Here -->
    <form action="./login" method="post" class="space-y-6">

        <!-- Username -->
        <div>
            <label for="username" class="block text-sm font-semibold text-gray-700">Username</label>
            <input type="text" id="username" name="username" required class="w-full p-3 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-600" placeholder="Enter your username">
        </div>

        <!-- Password -->
        <div>
            <label for="password" class="block text-sm font-semibold text-gray-700">Password</label>
            <input type="password" id="password" name="password" required class="w-full p-3 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-600" placeholder="Enter your password">
        </div>

        <!-- Error Message Display -->
        <!-- Form Starts Here -->
        <%
            String error = (String) request.getAttribute("errorMessage");
            if (error != null) {
        %>
        <div class="mb-4 p-3 bg-red-100 text-red-700 border border-red-400 rounded-md text-sm">
            <%= error %>
        </div>
        <%
            }
        %>


        <!-- Login Button -->
        <div class="mt-6">
            <button type="submit" class="w-full py-3 bg-blue-600 text-white rounded-md shadow-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-600">
                Login
            </button>
        </div>

        <!-- Redirect to Sign Up -->
        <div class="text-center mt-4">
            <p class="text-sm text-gray-600">Don't have an account? <a href="./signup.jsp" class="text-blue-600 font-semibold hover:underline">Sign Up</a></p>
        </div>
    </form>
    <!-- Form Ends Here -->
</div>

</body>

</html>
