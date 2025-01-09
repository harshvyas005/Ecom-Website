<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><b>EcomListProducts</b></h1>

<%@ page import="java.util.List" %>
<%@ page import="com.Bean.EproductBean" %>


<% 
	List<EproductBean> products=(List<EproductBean>)request.getAttribute("products");
%>
<a href="newproduct">new product</a>
<a href="deletebyname">Delete By Name</a>
<a href="ehome">home</a>
<table border="1">
	<tr>
		<th>productsId</th>
		<th>productsName</th>
		<th>Action</th>
	</tr>
	
	<%
		for(EproductBean p:products)
		{
			out.print("<tr>");
			out.print("<td>"+p.getProductId()+"</td><td>"+p.getProductName()+"</td><td><a href='deleteproduct?productId="+p.getProductId()+"'>Delete</a>|<a href='viewproduct?productId="+p.getProductId()+"'>View</a></td>");
			out.print("</tr>");
		}
	
	%>



</table>

</body>
</html>