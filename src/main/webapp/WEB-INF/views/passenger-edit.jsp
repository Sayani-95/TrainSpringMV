<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="./style.jsp"%>
</head>
<body>
<div class="d-flex align-items-center">
	<a href="../passenger/record" class="btn btn-primary text-center p-2"> Passenger </a>
	<br/> 
	<a href="../ticket/record" class="btn btn-primary text-center p-2">Ticket</a>
	<a href="../booking/record" class="btn btn-primary text-center p-2">Booking</a>
</div>
<h1>Passenger - Update</h1>

    <div class="container mt-3">

		
		<form method="post" action="../update" modelAttribute="passenger">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="id">Id</label> <input type="text"
							value="${passenger.id}" class="form-control" id="id" name="id"
							readonly="readonly">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							value="${passenger.name}" class="form-control" id="name" name="name"
							placeholder="Enter Name">
					</div>
				</div>
			</div>
				<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="gender">Gender</label> <input type="text"
							value="${passenger.gender}" class="form-control" id="gender" name="gender"
							placeholder="Enter Gender">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="email">Email</label> <input
							type="text" value="${passenger.email}" class="form-control" id="email"
							name="email" placeholder="Enter Email">
					</div>
				</div>
				</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
</form>
</body>
</html>