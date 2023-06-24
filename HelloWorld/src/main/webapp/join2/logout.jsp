<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//String id = (String)session.getAttribute("id");
	session.removeAttribute("id");
	session.removeAttribute("pw");

	Enumeration<String> e = session.getAttributeNames();
	while(e.hasMoreElements()) {
		String name = e.nextElement().toString();
		String value = session.getAttribute(name).toString();
		
		out.println(name + " : " + value);
		out.println("<br/>");
	}
	%>
	로그아웃 되었습니다.
	<br/>
	<a href="main.jsp">메인페이지</a>
	<a href="login.jsp">다시로그인</a>
</body>
</html>