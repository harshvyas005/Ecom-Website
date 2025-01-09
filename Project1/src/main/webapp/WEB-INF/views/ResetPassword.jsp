<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>RESET PASSWORD</h1><br><br>
	<form action="resetpassword" method="post">
    <input type="hidden" name="email" value="${email}">
    <label for="newPassword">New Password:</label>
    <input type="password" id="newPassword" name="newPassword" required>
    <button type="submit">Reset Password</button>
</form>
</body>
</html>