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

<h1>Booking - List</h1>
<a href="create" class="btn btn-primary"> Add Booking </a>
		<div class="row">

<table class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Passenger</th>
        <th>Ticket</th>
        
    </tr>
    <c:forEach var="booking" items="${bookings}">
        <tr>
            <td class="table-plus">${booking.id}</td>
            <td>${booking.passenger_id} - ${booking.passenger_name} </td>
            <td>${booking.ticket_id} - ${booking.ticket_name}</td>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>