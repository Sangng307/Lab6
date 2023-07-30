<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
	<div class="container col-7 pt-2">
		<div class="border rounded bg-light pl-4 pr-4 p-3">
			<div class="row p-2 pl-3 pt-3 bg-secondary text-white rounded">
				<h2>Lab6</h2>
			</div>
			<div class="row p-2">
				<div class="col">
					<c:if test="${not empty message}">
						<div class="alert alert-success">${message}</div>
					</c:if>
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<form action="/JAVA4LAB6/findVideoId" method="post">
						<div class="form-group pt-2">
							<label>Tìm kiếm:</label> <input type="text" name="search" placeholder="videoid"
								class="form-control" />
						</div>
						<div class="form-group pt-2">

							<button class="btn btn-danger mr-2">Find by VideoId</button>
						</div>
					</form>
				</div>
				</div>
			</div>
			<hr>
			
			
				<div class="row pt-0 pl-3 pr-3">
					<table class="table border border-dark">
						<thead class="thead-dark font-weight-bold bg-primary text-white">
							<tr>
								<td>Username</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Role</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${users}">
								<tr>
									<th>${item.id}</th>
									<th>${item.fullname}</th>
									<th>${item.email}</th>
									<th>${item.admin ? 'admin' : 'user'}</th>
								</tr>
							</c:forEach>
						<tbody>
					</table>
				</div>
		</div>
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>