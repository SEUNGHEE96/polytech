<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="memberProc.jsp" method="post">
		아이디 : <input type="text" name="id" size="10"><br/>
		비밀번호 : <input type="password" name="pwd" size="10"><br/>
		이름 : <input type="text" name="name" size="10"><br/>
		이메일 : <input type="email" name="email"><br/>		
		<input type="submit" value="전송">
		<input type="reset" value="초기화">
	</form>
</body>
</html>