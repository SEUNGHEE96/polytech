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
	String name = (String) session.getAttribute("name");
	String phone1 = (String) session.getAttribute("phone1");
	String phone2 = (String) session.getAttribute("phone2");
	String phone3 = (String) session.getAttribute("phone3");
    String gender = (String) session.getAttribute("gender");
	%>
	
	������ ���� <br/>
	id : <%=id %> <br/>
	pw : <%=pw %> <br/>
	name : <%=name %> <br/>
	phone1 : <%=phone1 %> <br/>
	phone2 : <%=phone2 %> <br/>
	phone3 : <%=phone3 %> <br/>
	gender : <%=gender %> <br/>
	
	<a href="modify.jsp">�ٽ� �����ϱ�</a>
	<a href="logout.jsp">�α׾ƿ��ϱ�</a>
	
</body>
</html>