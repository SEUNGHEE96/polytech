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
	<%
		MemberDAO md = new MemberDAO();
	
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		MemberDTO dto = new MemberDTO(id, pw, name, phone1, phone2, phone3, gender);
		int result = md.insertMember(dto);
		
		if (result >= 1) {
			out.println("ȸ�����Կ� �����ϼ̽��ϴ�.");
			out.println("�̸�: " + name + ", ���̵�: " + id + ", ��й�ȣ: " + pw + "<br/>");
			//response.sendRedirect("pass.jsp?age=" + age);
		} else {
			out.println("ȸ�����Կ� �����ϼ̽��ϴ�.");
			//response.sendRedirect("notpass.jsp?age=" + age);
		}
	%>
	<a href="join.jsp">ȸ������</a>
	<a href="login.jsp">�α���</a>
</body>
</html>