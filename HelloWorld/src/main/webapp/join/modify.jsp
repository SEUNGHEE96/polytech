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
	
	id : <%=id %> 
	pw : <%=pw %> <br/>
	
	수정할 정보 : <br/>
	<form action="ModifyOk" method="post">
		비밀번호 : <input type="password" name="pw" size="10"><br/>
		이름 : <input type="text" name="name" size="10"><br/>
		전화번호1 : <input type="text" name="phone1" size="10"><br/>
		전화번호2 : <input type="text" name="phone2" size="10"><br/>
		전화번호3 : <input type="text" name="phone3" size="10"><br/>
		성별 : <input type="radio" name="gender" value="m">남성
		<input type="radio" name="gender" value="f">여성<br/>
		<input type="submit" value="전송">
		<input type="reset" value="초기화">
	</form>
	
</body>
</html>