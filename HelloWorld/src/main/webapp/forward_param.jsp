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
		String id, paswd;
	%>
	
	<%
		id = request.getParameter("id");
		paswd = request.getParameter("paswd");
	%>
	
	${pageScope.id }
	${requestScope.id }
	${sessionScope.id }
	${applicationScope.id }
	<h1>forward.jsp �Դϴ�.</h1>
	���̵� : <%= id %> �Դϴ�. <br/>
	��й�ȣ : <%= paswd %> �Դϴ�. <br/>
</body>
</html>