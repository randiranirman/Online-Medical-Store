<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.example.onlinemediclestore.Classes.Medicine" %>
<%
    List<Medicine> medicines = (List<Medicine>) request.getAttribute("medicines");
    String imagePath = "uploads/"; // relative to web directory
%>

<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<h1>Available Medicines</h1>
<div style="display: flex; flex-wrap: wrap;">
    <% if (medicines != null) {
        for (Medicine med : medicines) { %>
    <div style="margin: 10px; border: 1px solid #ccc; padding: 10px;">
        <img src="<%= imagePath + med.getImg_path() %>" width="150" height="150" alt="Medicine Image"/>
        <h3><%= med.getName() %></h3>

        <p>Price: $<%= med.getPrice() %></p>
        <p>Quantity: <%= med.getQuantity() %></p>
    </div>
    <%  }
    } else { %>
    <p>No medicines found.</p>
    <% } %>
</div>
</body>
</html>
