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
	
	�α��� ���� : 
	id : <%=id %> 
	pw : <%=pw %> <br/>
	
	<a href="login.jsp">�α���</a>
	<a href="modify.jsp">ȸ����������</a>
	<a href="logout.jsp">�α׾ƿ�</a>
</body>
</html>