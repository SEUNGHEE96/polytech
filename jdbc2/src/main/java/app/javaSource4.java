package app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class javaSource4 {

	public static void main(String[] args) {

		// jdbc 커넥션 생성
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

		int pageSize = 10000; // 한 번에 가져올 데이터 양
		
	    String sql = "CREATE OR REPLACE PROCEDURE INSERTBONUS2 IS "
	    		+ "   TYPE bonus_record_t IS RECORD ( "
	    		+ "      empno EMP.EMPNO%TYPE, "
	    		+ "      bonus_sal BONUS.BONUS_SAL%TYPE "
	    		+ "   ); "
	    		//bonus_record_t라는 PL/SQL 컴포지트 데이터 유형을 정의
	    		+ "   TYPE bonus_records_t IS TABLE OF bonus_record_t; "
	    		+ "   v_bonus_records bonus_records_t; "
	    		+ "   CURSOR c_bonus IS "
	    		+ "      SELECT MGR_EMPNO, CASE WHEN COUNT(*) > 100000 THEN 2000 ELSE 1000 END AS bonus_sal "
	    		+ "      FROM CUSTOMER "
	    		+ "      WHERE MGR_EMPNO NOT IN (SELECT EMPNO FROM EMP WHERE JOB IN ('PRESIDENT', 'ANALYST')) "
	    		+ "      GROUP BY MGR_EMPNO; "
	    		+ "   v_yyyymm VARCHAR2(6) := '202306'; "
	    		+ "BEGIN "
	    		+ "   OPEN c_bonus; "
	    		//FETCH 문에서는 BULK COLLECT INTO 구문을 사용하여 데이터를 한 번에 가져와 컬렉션에 저장
	    		+ "   FETCH c_bonus BULK COLLECT INTO v_bonus_records; "
	    		+ "   FORALL i IN 1..v_bonus_records.COUNT "
	    		+ "      INSERT INTO BONUS(YYYYMM, EMPNO, BONUS_SAL) "
	    		+ "      VALUES (v_yyyymm, v_bonus_records(i).empno, v_bonus_records(i).bonus_sal); "
	    		+ "   CLOSE c_bonus; "
	    		+ "   COMMIT; "
	    		+ "EXCEPTION "
	    		+ "   WHEN OTHERS THEN "
	    		+ "      ROLLBACK; "
	    		+ "END;";
	    
		try {
			ps = conn.prepareStatement(sql);
			ps.setFetchSize(pageSize);
			ps.execute();
			
			try (CallableStatement statement = conn.prepareCall("{CALL INSERTBONUS2}")) {
				statement.execute();
			}
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
