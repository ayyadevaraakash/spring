<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>

	<h3>This is the profile page</h3>

	<h5>${user.getEmail()}</h5>
	<h5>${user.getPassword()}</h5>

</body>
</html>
