<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="objelOk.jsp" method="POST">
		아이디 : <input type="text" name="id"><br />
		비밀번호 : <input type="password" name="pw">
		<input type="submit" value="login">
	</form>

	<%
	application.setAttribute("application_name", "application_value"); //application 객체
	session.setAttribute("session_name", "session_value"); //session 객체
	pageContext.setAttribute("page_name", "page_value"); //pageContext 객체
	request.setAttribute("request_name", "request_value"); //request 객체
	%>
	
    pageScope : ${ pageScope.page_name }<br />
    requestScope : ${ requestScope.request_name }
</body>
</html>