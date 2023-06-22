<%@ page import="java.sql.*"%>
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
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink13";
	String user = "c##scott";
	String passwd = "tiger";
	%>

	<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");

	Class.forName(driver);
	conn = DriverManager.getConnection(url, user, passwd);
	String sql = "insert into member(id, pw, name, phone) values(?, ?, ?, ?)";
	try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, name);
		ps.setString(4, phone);
		ps.executeUpdate();
		
		out.println("화원가입 완료");
		out.println("id : " + id + "pwd : " + pwd + "name : " + name + "phone : " + phone);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
			//close(ps);
		} catch (SQLException e) {
		}
	}
	%>
	<br/>
	<a href="joinResult.jsp">회원 목록 보러가기</a>
</body>
</html>