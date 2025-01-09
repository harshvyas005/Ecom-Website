<!DOCTYPE html>
<%@page import="com.Bean.EwishListProductBean"%>
<%@page import="com.Bean.WishListBean"%>
<%@page import="com.Bean.EcartProductBean"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        color: #333;
    }

    h1 {
        text-align: center;
        margin-top: 20px;
        color: #007BFF;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }

    th, td {
        padding: 12px;
        text-align: center;
        border: 1px solid #ddd;
    }

    th {
        background-color: #007BFF;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

    a {
        text-decoration: none;
        color: #007BFF;
    }

    a:hover {
        text-decoration: underline;
    }

    .links {
        text-align: center;
        margin: 20px;
    }

    img {
        width: 100px; /* Adjust width as needed */
        height: auto;
    }

    .total-price {
        text-align: center;
        margin: 20px;
        font-size: 1.2em;
        font-weight: bold;
        color: #333;
    }
</style>
</head>
<body>
<h1>WISHLIST<h1>

<%@ page import="java.util.List" %>
<%@ page import="com.Bean.WishListBean" %>

<% 
    List<EwishListProductBean> products = (List<EwishListProductBean>) request.getAttribute("products");
%>

<div class="links">
    <a href="userproducts">BACK</a> |
    <a href="ehome">HOME</a> | 
    <a href="mycart">CART</a> 
    
  
</div>


<table>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    
    <%
        for (EwishListProductBean p : products) {
            out.print("<tr>");
            out.print("<td>" + p.getProductId() + "</td>");
            out.print("<td>" + p.getProductName() + "</td>");
            out.print("<td><img src='" + p.getProductImagePath() + "' alt='Product Image'></td>");
            out.print("<td>" +
                    "<a href='viewproduct?productId=" + p.getProductId() + "'>View</a> | " +
                    "<a href='deletefromwishlist?productId=" + p.getProductId() + "'>Remove</a> | " +
                    "<a href='addtocart?productId=" + p.getProductId() + "'>Add to Cart</a>" +
                  "</td>");

            out.print("</tr>");
          
        }
    %>
</table>



		 	


</body>
</html>
