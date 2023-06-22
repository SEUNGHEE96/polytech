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
	Statement st;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink13";
	String user = "c##scott";
	String passwd = "tiger";
	%>

	<%
	Class.forName(driver);
	conn = DriverManager.getConnection(url, user, passwd);
	String sql = "select * from member";
	try {
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pwd = rs.getString("pw");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			
			out.println("id : " + id + "| pwd : " + pwd + "| name : " + name + "| phone : " + phone + "<br/>");
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
	<a href="login.html">로그인하러가기</a>
</body>
</html>