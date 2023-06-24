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
	String name;
	String phone1;
	String phone2;
	String phone3;
	String gender;
	%>

	<%
	id = (String) session.getAttribute("id");
    pw = (String) session.getAttribute("pw");
    
	MemberDAO md = new MemberDAO();
	MemberDTO dto = md.selectMember(id, pw);
	
	name = dto.getName();
	phone1 = dto.getPhone1();
	phone2 = dto.getPhone2();
	phone3 = dto.getPhone3();
	gender = dto.getGender();
	%>
	
	id : <%=id %> 
	pw : <%=pw %> <br/>
	
	수정할 정보 : <br/>
	<form action="modifyOk.jsp" method="post">
		비밀번호 : <input type="password" name="pw" size="10" placeholder="<%=pw %>"><br/>
		이름 : <input type="text" name="name" size="10" placeholder="<%=name %>"><br/>
		전화번호1 : <input type="text" name="phone1" size="10" placeholder="<%=phone1 %>"><br/>
		전화번호2 : <input type="text" name="phone2" size="10" placeholder="<%=phone2 %>"><br/>
		전화번호3 : <input type="text" name="phone3" size="10" placeholder="<%=phone3 %>"><br/>
		<% if(gender.equals("M")) {
			out.println("성별 : <input type=\"radio\" name=\"gender\" value=\"m\" checked=\"checked\">남성"
					+ "<input type=\"radio\" name=\"gender\" value=\"f\">여성<br/>");
			} else {
				out.println("성별 : <input type=\"radio\" name=\"gender\" value=\"m\">남성"
					+ "<input type=\"radio\" name=\"gender\" value=\"f\" checked=\"checked\">여성<br/>");
			}
		%>
		<input type="submit" value="전송">
		<input type="reset" value="초기화">
	</form>
	<a href="main.jsp">메인페이지</a>
</body>
</html>