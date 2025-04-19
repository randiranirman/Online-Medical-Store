<%--
  Created by IntelliJ IDEA.
  User: Randira Nirman
  Date: 4/19/2025
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>THis is the  medicine page </title>
</head>
<body>
<form action="addMedicine" method="post" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="Medicine Name" required />
    <input type="text" name="description" placeholder="Description" required />
    <input type="number" name="price" placeholder="Price" required step="0.01" />

    <label>Upload Image:</label>
    <input type="file" name="image" accept="image/*" required />

    <button type="submit">Add Medicine</button>
</form>


</body>
</html>
