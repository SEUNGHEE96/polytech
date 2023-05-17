package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class javaSource5 {

	public static void main(String[] args) {

		//jdbc 커넥션 생성
		Connection conn = getConnection();
		// 로직 실행 시작 전 시간 저장
		long startTime = System.currentTimeMillis();
		// 만들어놓은 로직 실행
		empList(conn);
		// 로직 실행 완료 후 시간 저장
		long endTime = System.currentTimeMillis();
		// 시작 후 - 시작 전 시간 연산
		long elapsedTime = endTime - startTime;
		System.out.println("실행 시간: " + elapsedTime + "ms");
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

	public static void empList(Connection conn) {
		PreparedStatement ps = null;

		String sql = "INSERT INTO BONUS(YYYYMM, EMPNO, BONUS_SAL) "
				+ "SELECT '202306', MGR_EMPNO, CASE WHEN COUNT(*) > 100000 THEN 2000 ELSE 1000 END BONUS_SAL "
				+ "FROM CUSTOMER "
				+ "WHERE MGR_EMPNO NOT IN (SELECT EMPNO FROM EMP WHERE JOB IN('PRESIDENT', 'ANALYST')) "
				+ "GROUP BY MGR_EMPNO";
		try {
			ps = conn.prepareStatement(sql);
	        ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
