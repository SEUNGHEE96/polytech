<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" class="ex.Student" scope="session"/>
	
	<jsp:setProperty name="student" property="name" value="ȫ�浿" />
	<jsp:setProperty name="student" property="age" value="20"/>
	<jsp:setProperty name="student" property="grade" value="1"/>
	<jsp:setProperty name="student" property="studentNum" value="20230001"/>
	
	<jsp:getProperty name="student" property="name" /> <br/>
	<jsp:getProperty name="student" property="age" /> <br/>
	<jsp:getProperty name="student" property="grade" /> <br/>
	<jsp:getProperty name="student" property="studentNum" /> <br/>
	<!-- �Ʒ��� el�±�, ���� ���� ���� -->
	<br/>
	${student.name} <br/>
	${student.age } <br/>
	${student.grade } <br/>
	${student.studentNum } <br/>
	<br/>
	${1+2 }
	${10/5 }
</body>
</html>