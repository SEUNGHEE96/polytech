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
	<%
	String id = (String)session.getAttribute("id");
	session.removeAttribute(id);

	Enumeration<String> e = session.getAttributeNames();
	
	while(e.hasMoreElements()) {
		String name = e.nextElement().toString();
		String value = session.getAttribute(name).toString();
		
		out.println(name + " : " + value);
		out.println("<br/>");
	}
	%>
	로그아웃 되었습니다.
	
	<a href="login.html">다시 로그인하러가기</a>
</body>
</html>