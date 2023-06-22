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

	if (id.equals("ari") && pwd.equals("1234")) {
		session.setAttribute(id, pwd);
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>