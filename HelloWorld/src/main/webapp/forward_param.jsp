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
		String id, paswd;
	%>
	
	<%
		id = request.getParameter("id");
		paswd = request.getParameter("paswd");
	%>
	
	<h1>forward.jsp 입니다.</h1>
	아이디 : <%= id %> 입니다. <br/>
	비밀번호 : <%= paswd %> 입니다. <br/>
</body>
</html>