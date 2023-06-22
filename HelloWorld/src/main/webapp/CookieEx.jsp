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
	Cookie cookie = new Cookie("memberid", "admin");
	Cookie cookie2 = new Cookie("cookiesN", "cookiesN");

	response.addCookie(cookie);
	response.addCookie(cookie2);
	
	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i < cookies.length; i++) {
		out.println(cookies[i].getName() + " : " + cookies[i].getValue() + "<br>/");
	}
	%>
	
	<a href="cookiedel.jsp">삭제</a>
</body>
</html>