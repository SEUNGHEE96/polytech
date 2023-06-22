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
	String id = request.getParameter("id");
	String strPwd = request.getParameter("pwd");
	int pwd = Integer.parseInt(strPwd);
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	%>
	
	<jsp:useBean id="member" class="ex.member" scope="session"/>
	
	<jsp:setProperty name="member" property="id" value="<%= id %>"/>
	<jsp:setProperty name="member" property="pwd" value="<%= pwd %>"/>
	<jsp:setProperty name="member" property="name" value="<%= name %>"/>
	<jsp:setProperty name="member" property="email" value="<%= email %>"/>
	
	<%
	response.sendRedirect("memberConfirm.jsp");
	%>
</body>
</html>