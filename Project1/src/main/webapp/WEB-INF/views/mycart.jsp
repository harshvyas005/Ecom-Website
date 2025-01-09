<!DOCTYPE html>
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
<h1>My Cart</h1>

<%@ page import="java.util.List" %>
<%@ page import="com.Bean.EproductBean" %>

<% 
    List<EcartProductBean> products = (List<EcartProductBean>) request.getAttribute("products");
    Float productPrice = 0.0f;
%>

<div class="links">
    <a href="userproducts">BACK</a> |
    <a href="ehome">HOME</a> | 
    <a href="wishlist">WISHLIST</a> 
    
  
</div>


<table>
    <tr>
    	<th>cartId</th>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Image</th>
        <th>QTY</th>
        <th>Total Price</th>
        <th>Action</th>
    </tr>
    
    <%
        for (EcartProductBean p : products) {
            out.print("<tr>");
            out.print("<td>" + p.getCartId() + "</td>");
            out.print("<td>" + p.getProductId() + "</td>");
            out.print("<td>" + p.getProductName() + "</td>");
            out.print("<td><img src='" + p.getProductImagePath() + "' alt='Product Image'></td>");
            out.print("<td>" + p.getQty() + "</td>");
        	out.print("<td>" + p.getQty()*p.getPrice() + "</td>");
            out.print("<td><a href='deletefromcart?productId="+p.getProductId() +"'>Remove</a> | <a href='viewproduct?productId=" + p.getProductId() + "'>View</a></td>");
            out.print("</tr>");
            if (p.getPrice() != null) {
                productPrice +=p.getQty()*p.getPrice();
            }
        }
    %>
</table>

<div class="total-price">
    Total Price: <%= String.format("%.2f", productPrice) %>/-
</div>

		  <div class="links">
		  <a href="checkout">Proceed to Payment</a>
		  </div>	
<%        
	session.setAttribute("totalPrice", productPrice);
 %>

</body>
</html>
