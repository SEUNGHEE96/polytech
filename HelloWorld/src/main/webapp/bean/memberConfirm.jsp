<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="ex.member" scope="session"/>
	
	���̵� : <jsp:getProperty name="member" property="id"/><br/>
	��й�ȣ : <jsp:getProperty name="member" property="pwd"/><br/>
	�̸� : <jsp:getProperty name="member" property="name"/><br/>
	�̸��� : <jsp:getProperty name="member" property="email"/>
</body>
</html>