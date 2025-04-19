<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
            <label class="block mb-1 font-medium text-gray-700">Upload Image</label>
            <input type="file" name="image" accept="image/*" required
                   class="w-full border border-gray-300 p-2 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>

        <div class="text-center">
            <button type="submit"
                    class="bg-blue-600 text-white px-6 py-3 rounded-md hover:bg-blue-700 transition duration-300">
                Add Medicine
            </button>
        </div>
    </form>
</div>

<!-- Footer -->
<footer class="mt-16 bg-white shadow-inner py-4 text-center text-gray-500 text-sm">
    &copy; 2025 Medicare. All rights reserved.
</footer>

</body>
</html>
