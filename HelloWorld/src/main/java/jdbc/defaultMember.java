package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class defaultMember {

	public static void main(String[] args) {

		//jdbc 커넥션 생성
		Connection conn = getConnection();
		createTable(conn);
		System.out.println("기본 데이터 생성 완료");
	}
	
	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.119.119:1521/dink13";
			String user = "c##scott";
			String passwd = "tiger";
			conn = DriverManager.getConnection(url, user, passwd);
			// 자동커밋 방지
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// 드라이버 로드 중 예외가 발생한 경우 처리합니다.
			e.printStackTrace();
		} catch (SQLException e) {
			// 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
			e.printStackTrace();
		}
		return conn;
	}

	public static void createTable(Connection conn) {
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		
		String sql = "CREATE TABLE MEMBER ("
		        + "ID VARCHAR2(20),"
		        + "PW VARCHAR2(20),"
		        + "NAME VARCHAR2(20),"
		        + "PHONE VARCHAR2(20)"
		        + ")";
		
		String sql2 = "INSERT ALL "
				+ "INTO member(id, pw, name, phone) VALUES('abc', '123', '홍길동', '010-1234-5678')\r\n"
				+ "INTO member(id, pw, name, phone) VALUES('def', '456', '홍길순', '010-2345-5678')\r\n"
				+ "INTO member(id, pw, name, phone) VALUES('ghi', '789', '홍길이', '010-3456-5678')\r\n"
				+ "INTO member(id, pw, name, phone) VALUES('jkl', '123', '홍길남', '010-4567-5678')\r\n"
				+ "SELECT 1 FROM DUAL";
		
		try {
			ps = conn.prepareStatement(sql);
	        ps.execute();
	        ps2 = conn.prepareStatement(sql2);
	        ps2.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
				ps2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
