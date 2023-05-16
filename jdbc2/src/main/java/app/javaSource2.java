package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class javaSource2 {

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
		HashMap<Integer, Integer> emp = new HashMap<Integer, Integer>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		PreparedStatement ps3 = null;

		int pageSize = 10000; // 한 번에 가져올 데이터 양
		Set<Integer> keys = new HashSet<Integer>(); // 빠른 연산을 위한 key값 저장

		// 두 쿼리문 모두 필요한 컬럼만 조회한다.
		String sql = "SELECT EMPNO,JOB FROM EMP";
		String sql2 = "SELECT MGR_EMPNO FROM CUSTOMER";
		String sql3 = "INSERT INTO BONUS(YYYYMM, EMPNO, BONUS_SAL) VALUES ('202306', ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
	        ps.setFetchSize(pageSize);
	        rs = ps.executeQuery();
	        
	        while (rs.next()) {
				// PRESIDENT와 ANALYST는 저장하지 않는다.
				if (rs.getString("JOB").equals("PRESIDENT") || rs.getString("JOB").equals("ANALYST")) {
					continue;
				} else {
					int empno = rs.getInt("EMPNO");
					keys.add(empno);
					emp.put(empno, 0);
				}
			}

			ps2 = conn.prepareStatement(sql2);
		    ps2.setFetchSize(pageSize);
			rs2 = ps2.executeQuery();

			while (rs2.next()) {
				int empno = rs2.getInt("MGR_EMPNO");
				// 만약 모두 10만이 넘어서 SET에 데이터가 없다면 반복문을 종료한다. (=570만건 전부 조회할 필요 X)
				if (keys.isEmpty()) {
					break;
				} else if (emp.containsKey(empno)) {
					int customer = emp.get(empno);
					// HASHMAP에 저장한 고객수가 10만이 넘으면 SET에서 삭제한다. (=더 이상 카운트하지 않는다)
					if (customer > 100000) {
						keys.remove(empno);
					} else {
						// HASHMAP에서 회원 수 조회한 후 값을 1 늘려준다.
						emp.replace(empno, customer + 1);
					}
					// EMPNO가 EMP에 없다면 (=JOB이 PRESIDENT 혹은 ANALYST라면) 다시 반복문으로 올라간다.
				} else if (!emp.containsKey(empno)) {
					continue;
				}
			}

			Set<Integer> empKeys = emp.keySet();
			for (int empno : empKeys) {
				ps3 = conn.prepareStatement(sql3);
				ps3.setFetchSize(pageSize);
				ps3.setInt(1, empno);
				// 담당한 고객이 10만 이상이라면 보너스는 2000
				if (emp.get(empno) > 100000) {
					ps3.setInt(2, 2000);
					// 아니라면 보너스는 1000
				} else {
					ps3.setInt(2, 1000);
				}
				ps3.executeUpdate();
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
