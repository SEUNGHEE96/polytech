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
	id = request.getParameter("id");
	pwd = request.getParameter("pwd");
	
	Cookie cookie = new Cookie(id, pwd);

	response.addCookie(cookie);
	
	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i < cookies.length; i++) {
		out.println(cookies[i].getName() + " : " + cookies[i].getValue() + "<br>/");
	}
	%>
	
	<a href="logout.jsp">로그아웃</a>
</body>
</html>