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
		String age = request.getParameter("age");
	
		out.println("당신의 나이는 " + age + "세로 성인입니다.");
	%>
</body>
</html>