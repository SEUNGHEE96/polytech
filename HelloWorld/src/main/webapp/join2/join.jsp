<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="joinOk.jsp" method="post">
		���̵� : <input type="text" name="id" size="10"><br/>
		��й�ȣ : <input type="password" name="pw" size="10"><br/>
		�̸� : <input type="text" name="name" size="10"><br/>
		��ȭ��ȣ1 : <input type="text" name="phone1" size="10"><br/>
		��ȭ��ȣ2 : <input type="text" name="phone2" size="10"><br/>
		��ȭ��ȣ3 : <input type="text" name="phone3" size="10"><br/>
		���� : <input type="radio" name="gender" value="m">����
		<input type="radio" name="gender" value="f">����<br/>
		<input type="submit" value="����">
		<input type="reset" value="�ʱ�ȭ">
	</form>
</body>
</html>