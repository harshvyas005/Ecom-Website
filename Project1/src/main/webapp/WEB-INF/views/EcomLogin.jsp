<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>EcomLogin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-center mt-5">
            <div class="col-md-4">
                <div class="card shadow-lg">
                    <div class="card-body">
                        <h2 class="text-center mb-4">EcomLogin</h2>
                        <form action="elogin" method="post">
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" name="email" id="email" class="form-control" placeholder="Enter your email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" name="password" id="password" class="form-control" placeholder="Enter your password" required>
                            </div>
                            <div class="form-group text-right">
                                <a href="forgetpassword" class="text-muted">Forget Password?</a>
                            </div>
                            <button type="submit" class="btn btn-success btn-block">Login</button>
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
