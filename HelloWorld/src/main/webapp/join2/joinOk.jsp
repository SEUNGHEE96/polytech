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
			out.println("회원가입에 성공하셨습니다.");
			out.println("이름: " + name + ", 아이디: " + id + ", 비밀번호: " + pw + "<br/>");
			//response.sendRedirect("pass.jsp?age=" + age);
		} else {
			out.println("회원가입에 실패하셨습니다.");
			//response.sendRedirect("notpass.jsp?age=" + age);
		}
	%>
	<a href="join.jsp">회원가입</a>
	<a href="login.jsp">로그인</a>
</body>
</html>