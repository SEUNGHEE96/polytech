<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        background-color: #ffffff;
    }
    form {
        width: 600px;
        margin: 50px auto;
        text-align: center;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 5px;
        margin-bottom: 10px;
    }
    input[type="submit"],
    input[type="reset"] {
        padding: 10px;
        background-color: #374a12;
        color: #ffffff;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #567e26;
    }
</style>
</head>
<body>
	<form action="loginOk.jsp" method="post">
		���̵� : <input type="text" name="id" size="10"><br/>
		��й�ȣ : <input type="password" name="pw" size="10"><br/>
		<input type="submit" value="����">
		<input type="reset" value="�ʱ�ȭ">
	</form>
</body>
</html>