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

<h1>Create Booking</h1>
 <form method="post" action="create" modelAttribute="bookings"> 
    <table>
        <tr>
            <td>Passenger: </td>
            <td>
                <select id="passenger_id" name="passenger_id" required="required">
                    <c:forEach items="${passenger}" var="passenger">
                        <option value="${passenger.id}"> ${passenger.name} </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Ticket: </td>
            <td>
                <select id="ticket_id" name="ticket_id" required="required">
                    <c:forEach items="${ticket}" var="ticket">
                        <option value="${ticket.id}"> ${ticket.name} </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
                <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form>
</body>
</html>