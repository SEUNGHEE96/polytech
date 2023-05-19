package app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class javaSource3 {

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

		String sql = "CREATE OR REPLACE PROCEDURE INSERTBONUS IS "
				+ "    CURSOR c_emp IS "
				+ "        SELECT EMPNO "
				+ "        FROM EMP "
				+ "        WHERE JOB NOT IN ('PRESIDENT', 'ANALYST'); "
				+ "    CURSOR c_customer IS "
				+ "        SELECT MGR_EMPNO "
				+ "        FROM CUSTOMER; "
				+ "    v_yyyymm VARCHAR2(6) := '202306'; "
				+ "    v_empno NUMBER(4); "
				+ "    v_bonus_sal NUMBER(4); "
				+ "    v_count NUMBER(10); "
				+ "BEGIN "
				+ "    FOR rec IN c_emp LOOP "
				+ "        v_empno := rec.EMPNO; "
				//담당중인 고객 수를 반복문을 통해 COUNT
				+ "        v_count := 0; "
				+ "        FOR inner_rec IN c_customer LOOP "
				+ "            IF inner_rec.MGR_EMPNO = v_empno THEN "
				+ "                v_count := v_count + 1; "
				+ "            END IF; "
				+ "        END LOOP; "
				//보너스를 COUNT한 고객 수 기준으로 결정
				+ "        IF v_count > 100000 THEN "
				+ "            v_bonus_sal := 2000; "
				+ "        ELSE "
				+ "            v_bonus_sal := 1000; "
				+ "        END IF; "
				// 모두 정해진 BONUS를 INSERT를 통해 BONUS 테이블에 저장
				+ "        INSERT INTO BONUS(YYYYMM, EMPNO, BONUS_SAL) VALUES (v_yyyymm, v_empno, v_bonus_sal); "
				+ "    END LOOP; "
				+ "    COMMIT; "
				+ "EXCEPTION "
				+ "    WHEN OTHERS THEN "
				+ "        ROLLBACK; "
				+ "END;";
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			
			try (CallableStatement statement = conn.prepareCall("{CALL INSERTBONUS}")) {
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
