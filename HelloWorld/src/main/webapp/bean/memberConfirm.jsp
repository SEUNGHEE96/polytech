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
	
	아이디 : <jsp:getProperty name="member" property="id"/><br/>
	비밀번호 : <jsp:getProperty name="member" property="pwd"/><br/>
	이름 : <jsp:getProperty name="member" property="name"/><br/>
	이메일 : <jsp:getProperty name="member" property="email"/>
</body>
</html>