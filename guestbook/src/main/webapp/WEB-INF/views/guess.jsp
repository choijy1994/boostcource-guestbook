<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>guess number</title>
</head>
<body>
	<h1>guss number</h1>
	<hr>
	<h3>${message }</h3>
	<c:if test="${sessionScope.count!=null }">
		<form method="get" action="guess">
			1���� 100���� ���� ���纸����<br>
			<input type="text" name="number"><br>
			<input type="submit" value="submit">
		</form>
	</c:if>
	<a href="guess">���� �ٽ� ����</a>
</body>
</html>