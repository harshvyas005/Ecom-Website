<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Bean.EproductBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product View</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: "Poppins", sans-serif;
            color: #444444;
            background-color: #f8f9fa;
            padding: 20px;
        }
        .product-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            display: flex;
            align-items: center;
        }
        .product-image {
            max-width: 300px;
            margin-right: 20px;
        }
        .product-details {
            flex: 1;
        }
        .product-details h2 {
            font-size: 2rem;
            color: #333;
            margin-bottom: 20px;
        }
        .product-details p {
            font-size: 1.1rem;
            margin-bottom: 10px;
        }
        .product-details p span {
            font-weight: bold;
        }
        .links {
            text-align: center;
            margin: 20px;
        }
        @media (max-width: 768px) {
            .product-container {
                flex-direction: column;
                align-items: flex-start;
            }
            .product-image {
                margin-right: 0;
                margin-bottom: 20px;
            }
        }
    </style>
</head>
<body>

<div class="links">
    <a href="userproducts">Back</a> |
    <a href="ehome">Home</a> |
    <a href="logout">Logout</a> 
</div>

<%
    // Retrieve the list of products from the request attribute
    List<EproductBean> products = (List<EproductBean>) request.getAttribute("p");
    if (products != null) {
        for (EproductBean product : products) {
%>
            <div class="product-container">
                <img class="product-image" src="<%= product.getProductImagePath() %>" alt="<%= product.getProductName() %>" />
                <div class="product-details">
                    <h2>VIEW PRODUCT</h2>
                    <p><span>Product Name:</span> <%= product.getProductName() %></p>
                    <p><span>Price:</span> <%= product.getPrice() %></p>
                    <p><span>Category:</span> <%= product.getCategory() %></p>
                </div>
            </div>
<%
        }
    } else {
%>
        <div class="alert alert-warning text-center" role="alert">
            No products found!
        </div>
<%
    }
%>

</body>
</html>
