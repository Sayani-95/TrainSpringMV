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
	<a href="../vehicle/record" class="btn btn-primary text-center p-2"> Vehicle details </a>
	<a href="../incident/record" class="btn btn-primary text-center p-2">Incident details</a>
	<a href="../ticket/record" class="btn btn-primary text-center p-2">Ticket details</a>
</div>

<h1>Ticket - Create</h1>
<form method="post" action="create" modelAttribute="ticket">
    <table>
        <tr>
            <td>Ticket name: </td>
            <td><input type="text" id="name" name="name" required="required"/></td>
        </tr>
        <tr>
            <td>Ticket_date: </td>
            <td><input id="ticket_date" name="ticket_date" type="text" required="required"/></td>
        </tr>
            
            <td><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form>
</body>
</html>