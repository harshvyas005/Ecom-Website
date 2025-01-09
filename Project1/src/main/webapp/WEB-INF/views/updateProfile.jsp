<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #007BFF;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            font-weight: bold;
        }

        button {
            display: block;
            width: 100%;
        }
    </style>
</head>
<body>
    <!-- Navbar at the top -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Product Store</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="ehome">HOME</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">LOGOUT</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Update Profile Form -->
    <div class="container">
        <h1>Update Profile</h1>
        <%
            // Assuming userBean contains the user's details (passed from the controller)
            com.Bean.EuserBean userBean = (com.Bean.EuserBean) request.getAttribute("user");
            if (userBean == null) {
                out.print("<div class='text-danger text-center'>Error: User not found!</div>");
                return;
            }
        %>
        <form action="/updateProfile" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%= userBean.getId() %>">

            <div class="form-group">
                <label for="name">First Name:</label>
                <input type="text" name="name" id="name" class="form-control"
                       value="<%= userBean.getName() %>" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" class="form-control"
                       value="<%= userBean.getEmail() %>" required>
            </div>
            <div class="form-group">
                <label for="phoneNo">Phone Number:</label>
                <input type="tel" name="phoneNo" id="phoneNo" class="form-control"
                       value="<%= userBean.getPhoneNo() %>" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" class="form-control"
                       value="<%= userBean.getPassword() %>" required>
            </div>
            <div class="form-group">
                <label for="profilePic">Profile Picture:</label>
                <input type="file" name="profilePic" id="profilePic" class="form-control-file">
                <% if (userBean.getProfilePicPath() != null && !userBean.getProfilePicPath().isEmpty()) { %>
                    <img src="<%= userBean.getProfilePicPath() %>" alt="Current Profile Picture"
                         class="mt-2" style="width: 100px; height: auto; border: 1px solid #ddd; border-radius: 4px;">
                <% } else { %>
                    <p class="text-muted mt-2">No profile picture uploaded.</p>
                <% } %>
            </div>
            <button type="submit" class="btn btn-primary">Update Profile</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
