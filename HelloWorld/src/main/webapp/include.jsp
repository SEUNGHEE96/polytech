<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "include01.jsp" %>
	<br/>
	<h3>����� include.jsp</h3>
	<!-- html �ּ� -->
	<%-- jsp �ּ� --%>
	
	<%
		out.println("ContextPath : " + request.getContextPath() + "<br/>");
		out.println("��û��� : " + request.getMethod() + "<br/>");
		out.println("���� ��ü : " + request.getSession() + "<br/>");
		out.println("�������� : " + request.getProtocol() + "<br/>");
		out.println("URL : " + request.getRequestURL() + "<br/>"); 
		out.println("URI : " + request.getRequestURI() + "<br/>");
		out.println("������Ʈ�� : " + request.getQueryString() + "<br/>");
	%>
</body>
</html>