<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<a href="insert.do">insert</a>
	<hr/>
	<a href="http://localhost:8080<%=request.getContextPath() %>/update.do">update</a>
	<hr/>
	<a href="http://localhost:8080/HelloWorld/select.do">update</a>
	<hr/>
	<a href="<%=request.getContextPath() %>/delete.do">delete</a>
	
</body>
</html>