<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Medicare - Online Medical Store</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 text-gray-800 font-sans">

<!-- Navbar -->
<nav class="bg-white shadow-md">
  <div class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
    <h1 class="text-2xl font-bold text-blue-600">Medicare</h1>
    <ul class="flex space-x-6 text-sm font-medium">
      <li><a href="#" class="hover:text-blue-600 transition">Home</a></li>
      <li><a href="#" class="hover:text-blue-600 transition">Medicines</a></li>
      <li><a href="#" class="hover:text-blue-600 transition">Contact</a></li>
      <li><a href="#" class="hover:text-blue-600 transition">Login</a></li>
    </ul>
  </div>
</nav>

<!-- Hero Section -->
<section class="bg-blue-100 py-20">
  <div class="max-w-6xl mx-auto text-center">
    <h2 class="text-4xl font-bold text-blue-700 mb-4">Your Trusted Online Medical Store</h2>
    <p class="text-lg text-blue-900 mb-6">Fast delivery, genuine medicines, and 24/7 customer support.</p>
    <a href="#" class="bg-blue-600 text-white px-6 py-3 rounded-full hover:bg-blue-700 transition">Shop Now</a>
  </div>
</section>

<!-- Featured Products -->
<section class="py-16 bg-white">
  <div class="max-w-6xl mx-auto px-4">
    <h3 class="text-2xl font-semibold mb-8 text-center text-gray-700">Featured Products</h3>
    <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
      <!-- Product Card -->
      <div class="bg-white rounded-lg shadow hover:shadow-lg transition p-4">
        <img src="https://via.placeholder.com/150" alt="Medicine" class="w-full h-40 object-cover mb-4 rounded">
        <h4 class="text-lg font-semibold text-gray-800">Paracetamol 500mg</h4>
        <p class="text-sm text-gray-600 mb-2">Effective pain relief tablet</p>
        <span class="text-blue-600 font-bold">Rs. 50</span>
      </div>

      <!-- Repeat above card as needed -->
      <div class="bg-white rounded-lg shadow hover:shadow-lg transition p-4">
        <img src="https://via.placeholder.com/150" alt="Medicine" class="w-full h-40 object-cover mb-4 rounded">
        <h4 class="text-lg font-semibold text-gray-800">Cough Syrup</h4>
        <p class="text-sm text-gray-600 mb-2">Soothes throat irritation</p>
        <span class="text-blue-600 font-bold">Rs. 80</span>
      </div>

      <!-- Add more product cards here -->
    </div>
  </div>
</section>

<!-- Footer -->
<footer class="bg-gray-100 py-6 text-center text-sm text-gray-600">
  &copy; 2025 Medicare. All rights reserved.
</footer>

</body>
</html>
