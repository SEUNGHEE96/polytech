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
	
	������ ���� : <br/>
	<form action="modifyOk.jsp" method="post">
		��й�ȣ : <input type="password" name="pw" size="10" placeholder="<%=pw %>"><br/>
		�̸� : <input type="text" name="name" size="10" placeholder="<%=name %>"><br/>
		��ȭ��ȣ1 : <input type="text" name="phone1" size="10" placeholder="<%=phone1 %>"><br/>
		��ȭ��ȣ2 : <input type="text" name="phone2" size="10" placeholder="<%=phone2 %>"><br/>
		��ȭ��ȣ3 : <input type="text" name="phone3" size="10" placeholder="<%=phone3 %>"><br/>
		<% if(gender.equals("M")) {
			out.println("���� : <input type=\"radio\" name=\"gender\" value=\"m\" checked=\"checked\">����"
					+ "<input type=\"radio\" name=\"gender\" value=\"f\">����<br/>");
			} else {
				out.println("���� : <input type=\"radio\" name=\"gender\" value=\"m\">����"
					+ "<input type=\"radio\" name=\"gender\" value=\"f\" checked=\"checked\">����<br/>");
			}
		%>
		<input type="submit" value="����">
		<input type="reset" value="�ʱ�ȭ">
	</form>
	<a href="main.jsp">����������</a>
</body>
</html>