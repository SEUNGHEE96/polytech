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
	<h3>여기는 include.jsp</h3>
	<!-- html 주석 -->
	<%-- jsp 주석 --%>
	
	<%
		out.println("ContextPath : " + request.getContextPath() + "<br/>");
		out.println("요청방식 : " + request.getMethod() + "<br/>");
		out.println("세션 객체 : " + request.getSession() + "<br/>");
		out.println("프로토콜 : " + request.getProtocol() + "<br/>");
		out.println("URL : " + request.getRequestURL() + "<br/>"); 
		out.println("URI : " + request.getRequestURI() + "<br/>");
		out.println("쿼리스트링 : " + request.getQueryString() + "<br/>");
	%>
</body>
</html>