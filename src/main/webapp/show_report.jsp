<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${not empty empList}">
		<table border="1" bgcolor="cyan">
			<tr>
				<th>Emp No</th>
				<th>Emp Name</th>
				<th>Emp Address</th>
				<th>Emp Salary</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.empname}</td>
					<td>${emp.empadd}</td>
					<td>${emp.empsal}</td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach var="i" begin="1" end="${pagecount}" step="1">
		<a href="controller?pageNumber=${i}&pagesize=${empList.size()}">[${i}]</a>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<h1>No data to display</h1>
	</c:otherwise>
</c:choose>
<br>
<a href="index.jsp">Home</a>
