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
		out.println("로그인에 성공하셨습니다. <br/>");
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		out.println("이름: " + dto.getName() + ", 아이디: " + dto.getId() + ", 비밀번호: " + dto.getPw() + "<br/>");
		//response.sendRedirect("main.jsp");
	} else {
		out.println("로그인에 실패하셨습니다. <br/>");
		//response.sendRedirect("login.jsp");
	}
	%>
	<a href="main.jsp">메인페이지</a>
	<a href="login.jsp">다시로그인</a>
</body>
</html>