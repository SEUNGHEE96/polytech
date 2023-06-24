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
	String pw;
	%>

	<%
	id = (String) session.getAttribute("id");
    pw = (String) session.getAttribute("pw");
	%>
	
	<h1>main.jsp</h1>
	
	로그인 정보 : 
	id : <%=id %> 
	pw : <%=pw %> <br/>
	
	<a href="login.jsp">로그인</a>
	<a href="modify.jsp">회원정보수정</a>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>