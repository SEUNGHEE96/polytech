<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	int i = 40 / 0;
	%>
	<c:choose>
		<c:when test="${login}">
		<p><a href="/logout.ok">�α׾ƿ�</a></p>
		</c:when>
		<c:otherwise>
		<p><a href="/login.ok">�α���</a></p>
		</c:otherwise>
		</c:choose>
</body>
</html>