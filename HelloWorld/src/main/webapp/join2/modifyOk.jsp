<%@page import="join2.MemberDTO"%>
<%@page import="join2.MemberDAO"%>
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
		MemberDAO md = new MemberDAO();
	
		String id = (String) session.getAttribute("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		
		MemberDTO dto = new MemberDTO(id, pw, name, phone1, phone2, phone3, gender);
		MemberDTO updateDto = md.updateMember(dto);
		
		if (updateDto != null) {
			out.println("ȸ�� ������ �����ϼ̽��ϴ�.");
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			out.println("���̵�: " + id + ", ��й�ȣ: " + pw + " �̸�: " + name + "<br/>");
			//response.sendRedirect("pass.jsp?age=" + age);
		} else {
			out.println("���� ������ �����ϼ̽��ϴ�.");
			//response.sendRedirect("notpass.jsp?age=" + age);
		}
	%>
	<a href="main.jsp">����������</a>
</body>
</html>