<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ecom SignUp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        body {
            background-color: #f8f9fa; /* Light background color */
            font-family: Arial, sans-serif; /* Consistent font */
        }
        .card {
            border-radius: 10px; /* Rounded corners for the card */
            border: none; /* Remove default border */
        }
        .card-body {
            padding: 2rem; /* Padding inside the card */
        }
        h2 {
            color: #343a40; /* Dark grey color for the title */
            font-weight: 700; /* Bolder title */
        }
        label {
            font-weight: 600; /* Semi-bold labels */
        }
        .form-control {
            border-radius: 5px; /* Slightly rounded input fields */
            border: 1px solid #ced4da; /* Border for input fields */
        }
        .btn-primary {
            background-color: #007bff; /* Custom button color */
            border-color: #007bff; /* Custom button border */
            border-radius: 5px; /* Rounded button */
            padding: 10px; /* Increase padding for the button */
        }
        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue on hover */
            border-color: #0056b3; /* Match border color on hover */
        }
        .text-danger {
            font-weight: 600; /* Bold error messages */
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
                <div class="card shadow-lg">
                    <div class="card-body">
                        <h2 class="text-center mb-4"><b>Ecom SignUp</b></h2>
                        <form action="esignup1" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="name">First Name:</label>
                                <input type="text" name="name" id="name" class="form-control" placeholder="Enter your first name" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" name="email" id="email" class="form-control" placeholder="Enter your email" required>
                            </div>
                            <div class="form-group">
                                <label for="phoneNo">Phone Number:</label>
                                <input type="tel" name="phoneNo" id="phoneNo" class="form-control" placeholder="Enter your phone number" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" name="password" id="password" class="form-control" placeholder="Create a password" required>
                            </div>
                            <div class="form-group">
                                <label for="profilePic">Profile Picture:</label><br>
                                <input type="file" name="profilePic" id="profilePic" class="form-control-file">
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
                        </form>
                        <br>
                        <span class="text-danger d-block text-center">${error}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
