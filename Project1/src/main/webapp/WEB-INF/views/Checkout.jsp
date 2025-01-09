<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Page</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand {
            font-weight: bold;
            color: #0d6efd !important;
        }
        .form-label {
            font-weight: 500;
        }
    </style>
</head>
<body>
    <% Float totalPrice = (Float) session.getAttribute("totalPrice"); %>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Product Store</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="ehome">HOME</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="mycart">CART</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="wishlist">WISHLIST</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">LOGOUT</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <h2 class="text-center mb-4">Payment Details</h2>
        <p class="text-center fs-5">Final Amount: <strong><%= totalPrice %>/-</strong></p>
        <form action="processPayment" method="post">
            <input type="hidden" name="amount" value="<%= totalPrice %>">

            <div class="mb-3">
                <label for="CardNumber" class="form-label">Credit Card Number</label>
                <input type="text" id="CardNumber" name="CardNumber" class="form-control" placeholder="Enter your credit card number" required>
            </div>

            <div class="mb-3">
                <label for="Date" class="form-label">Expiry Date</label>
                <input type="text" id="Date" name="Date" class="form-control" placeholder="MM/YY" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Pay</button>
        </form>
    </div>

    <!-- Include Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
