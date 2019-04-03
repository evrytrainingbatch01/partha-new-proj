<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<h3>Add / Edit Student!!!</h3>

	<form:form method="post" action="/SpringMVCTutorial/employee.html"
		commandName="student">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 300px">
				<tr>
					<td>Student Id :</td>
					<td><form:input type="text" path="studId" /></td>
				</tr>
				<tr>
					<td>Student Name :</td>
					<td><form:input type="text" path="studName" /></td>
				</tr>
				<tr>
					<td>Student Age :</td>
					<td><form:input type="text" path="studAge" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input class="btn btn-primary btn-sm" type="submit"
						value="Submit" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<h3>List of Students</h3>
	<table class="table table-bordered" style="width: 300px">
		<tr>
			<th>StudId</th>
			<th>StudName</th>
			<th>studAge</th>

			<th>Edit/Delete</th>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td width="60" align="center">${student.studId}</td>
				<td width="60" align="center">${student.stuName}</td>
				<td width="60" align="center">${student.stuAge}</td>
				<td width="60" align="center">${employee.dept}</td>
				<td width="60" align="center"><a href="edit/${student.studId}">Edit</a>/<a
					href="delete/${student.studId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>