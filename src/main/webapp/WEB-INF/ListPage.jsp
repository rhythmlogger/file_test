<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:forEach var="file" items="${list}" >
		<form action="/file_test/fileTest" method="post">
		<input type="hidden" name="fileName" value="${file}" >
		<input type="submit" value="${file}"/>
	</form>
	</c:forEach>
</body>
</html>