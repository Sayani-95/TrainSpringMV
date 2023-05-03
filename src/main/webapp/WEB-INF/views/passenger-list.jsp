<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./style.jsp"%>
<title>Insert title here</title>
</head>
<body>
<div class="d-flex align-items-center">
	<a href="../passenger/record" class="btn btn-primary text-center p-2"> Passenger </a>
	<br/> 
	<a href="../ticket/record" class="btn btn-primary text-center p-2">Ticket</a>
	<a href="../booking/record" class="btn btn-primary text-center p-2">Booking</a>
</div>

<br>
<div class="container mt-3">
<h1>Passenger - List</h1>
<a href="create" class="btn btn-primary"> Add Passenger </a>
		<div class="row">

<table class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Email</th>
    </tr>
    <c:forEach var="passenger" items="${passenger}">
        <tr>
            <td class="table-plus">${passenger.id}</td>
            <td>${passenger.name}</td>
            <td>${passenger.gender}</td>
            <td>${passenger.email}</td>
            <td><a href="edit/${passenger.id}">Edit</a> </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>