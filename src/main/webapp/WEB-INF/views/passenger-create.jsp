<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./style.jsp"%>
</head>
<body>
<div class="d-flex align-items-center">
	<a href="../passenger/record" class="btn btn-primary text-center p-2"> Passenger </a>
	<br/> 
	<a href="../ticket/record" class="btn btn-primary text-center p-2">Ticket</a>
	<a href="../booking/record" class="btn btn-primary text-center p-2">Booking</a>
</div>

<h1>Passenger - Create</h1>
<form method="post" action="create" modelAttribute="passenger">
    <table>
        <tr>
            <td>First name: </td>
            <td><input type="text" id="name" name="name" required="required"/></td>
        </tr>
        <tr>
            <td>gender: </td>
            <td><input id="gender" name="gender" type="text" required="required"/></td>
        </tr>
                <tr>
            <td>email: </td>
            <td><input id="email" name="email" type="text" required="required"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form>
</body>
</html>