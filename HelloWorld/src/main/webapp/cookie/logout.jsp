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
			
			out.println("�α׾ƿ� �� ���̵� :" + cookies[i].getName() + "<br/>");
			out.println("�α׾ƿ� �� ��й�ȣ : " + cookies[i].getValue() + "<br/>");
			out.println("----------------------------------------------");
		}
	}
	%>
</body>
</html>