<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//String id = (String)session.getAttribute("id");
	session.removeAttribute("id");
	session.removeAttribute("pw");

	Enumeration<String> e = session.getAttributeNames();
	while(e.hasMoreElements()) {
		String name = e.nextElement().toString();
		String value = session.getAttribute(name).toString();
		
		out.println(name + " : " + value);
		out.println("<br/>");
	}
	%>
	�α׾ƿ� �Ǿ����ϴ�.
	<br/>
	<a href="main.jsp">����������</a>
	<a href="login.jsp">�ٽ÷α���</a>
</body>
</html>