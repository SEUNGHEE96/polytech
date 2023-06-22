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
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String phone1 = rs.getString("phone1");
			String phone2 = rs.getString("phone2");
			String phone3 = rs.getString("phone3");
			String gender = rs.getString("gender");
			
			out.println("id : " + id + " | pw : " + pw + " | name : " + name + " | phone1 : " + phone1 + 
					" | phone2 : " + phone2 + " | phone3 : " + phone3 + " | gender : " + gender + "<br/>");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
	%>
	<a href="login.html">로그인하러가기</a>
</body>
</html>