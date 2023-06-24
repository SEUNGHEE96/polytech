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
			out.println("회원 정보를 수정하셨습니다.");
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			out.println("아이디: " + id + ", 비밀번호: " + pw + " 이름: " + name + "<br/>");
			//response.sendRedirect("pass.jsp?age=" + age);
		} else {
			out.println("정보 수정에 실패하셨습니다.");
			//response.sendRedirect("notpass.jsp?age=" + age);
		}
	%>
	<a href="main.jsp">메인페이지</a>
</body>
</html>