<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./style.jsp"%>
</head>
<body>
<a href="../user/sign-up">Sign up</a>
<a href="../user/sign-in">Sign in</a>
<h1>Sign Up</h1>
<form method="post" action="sign-up" >
    <div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">User name</label> <input type="text"
							class="form-control" id="username" name="username"
						>
					</div>
				</div>
			</div>
            <div class="row">
				<div class="col">
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>
				</div>
			</div>
        <button type="submit" class="btn btn-primary">Sign Up</button>
</form>
</body>
</html>