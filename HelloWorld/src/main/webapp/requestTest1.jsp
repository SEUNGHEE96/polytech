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
		request.setAttribute("id", "id1");
		request.setAttribute("pw", "pw1");
		
		response.sendRedirect("requestTest2.jsp");
	%>
</body>
</html>