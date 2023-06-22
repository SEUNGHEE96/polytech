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

	Class.forName(driver);
	conn = DriverManager.getConnection(url, user, passwd);
	String sql = "select * from member where id = ?";
	
	try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery(sql);
		
		if(rs.next() && rs.getString("PW").equals(pwd)) {
			response.sendRedirect("login.html");
		} else {
			response.sendRedirect("loginResult.jsp");
		}
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
</body>
</html>