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
	Cookie[] cookies = request.getCookies();

	for (int i = 0; i < cookies.length; i++) {
		String str = cookies[i].getName();
		
		if(str.equals("ari")) {
			cookies[i].setMaxAge(0);
			
			response.addCookie(cookies[i]);
			
			out.println("로그아웃 한 아이디 :" + cookies[i].getName() + "<br/>");
			out.println("로그아웃 한 비밀번호 : " + cookies[i].getValue() + "<br/>");
			out.println("----------------------------------------------");
		}
	}
	%>
</body>
</html>