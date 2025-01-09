<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="boxcricket" method="post">

<h1><b> BOX CRICKET REGISTRATION</b></h1>

<br>

NAME:<input type="text" name="name" value="${value.name}">
		<span style="color:red">${nameError}</span><br><br>
TYPE:<input type="radio" name="type" value="Batsman"${value.type=='Batsman'?'checked':''}>Batsman
	 <input type="radio" name="type" value="Bowler"${value.type=='Bowler'?'checked':''}>Bowler
	 <input type="radio" name="type" value="All-Rounder"${value.type=='All-Rounder'?'checked':''}>All-Rounder
	 <span style="color:red">${typeError}</span>
	 <br><br>
	 
FOOD PREFERENCE:<select name="food">
				<option value="-1">select food
				<option value="Regular"${value.food=='Regular'?'selected':'' }>Regular		
				<option value="Jain"${value.food=='Jain'?'selected':'' }>Jain
				</option></select>
				 <span style="color:red">${foodError}</span><br><br>
DRINK:<input type="checkbox" name="drink" value="RB"${ value.drink.contains("RB")?"checked":'' }>RB
	  <input type="checkbox" name="drink" value="MD"${ value.drink.contains("MD")?"checked":'' }>MD
	  <input type="checkbox" name="drink" value="TH"${ value.drink.contains("TH")?"checked":'' }>TH
	  <input type="checkbox" name="drink" value="LJ"${ value.drink.contains("LJ")?"checked":'' }>LJ
	  <input type="checkbox" name="drink" value="CO"${ value.drink.contains("CO")?"checked":'' }>CO
	   <span style="color:red">${drinkError}</span>
	<br><br>
<input type="submit" value="REGISTER">






</form>
</body>
</html>