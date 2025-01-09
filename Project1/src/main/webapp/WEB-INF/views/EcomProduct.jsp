<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><b>>Ecom Product</b></h1>

<form action="saveproduct" method="post" enctype="multipart/form-data">

ProductName:<input type="text" name="productName"><br><br>
Categoy:<input type="text" name="category"><br><br>
Price:<input type="text" name="price"><br><br>
Qty:<input type="text" name="qty"><br><br>
Master Image:<input type="file" name="masterImage"><br><br>

<input type="submit" value="Add product">






</form>



</body>
</html>