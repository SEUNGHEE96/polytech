<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
	String id;
	String pwd;
	%>

	<%
	Enumeration<String> e = session.getAttributeNames();
	
	while(e.hasMoreElements()) {
		String name = e.nextElement().toString();
		String value = session.getAttribute(name).toString();
		
		out.println(name + " : " + value);
	}
	%>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>