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
	String id = (String) session.getAttribute("id");
    String pw = (String) session.getAttribute("pw");
	%>
	
	�α��� ���� <br/>
	id : <%=id %> <br/>
	pw : <%=pw %> <br/>
	
	<a href="modify.jsp">ȸ������ ����</a>

</body>
</html>