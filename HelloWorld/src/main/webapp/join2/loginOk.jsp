<%@page import="join2.MemberDTO"%>
<%@page import="join2.MemberDAO"%>
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
	MemberDAO md = new MemberDAO();
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDTO dto = md.selectMember(id, pw);
	
	if (dto != null) {
		out.println("�α��ο� �����ϼ̽��ϴ�. <br/>");
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		out.println("�̸�: " + dto.getName() + ", ���̵�: " + dto.getId() + ", ��й�ȣ: " + dto.getPw() + "<br/>");
		//response.sendRedirect("main.jsp");
	} else {
		out.println("�α��ο� �����ϼ̽��ϴ�. <br/>");
		//response.sendRedirect("login.jsp");
	}
	%>
	<a href="main.jsp">����������</a>
	<a href="login.jsp">�ٽ÷α���</a>
</body>
</html>