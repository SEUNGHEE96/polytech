package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {

		// 1. Oracle JDBC 드라이버를 로드합니다.
		Connection conn = null;

		// 2. 데이터베이스에 연결합니다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "ip";
			String user = "id";
			String passwd = "pw";
			conn = DriverManager.getConnection(url, user, passwd);

			// 3. SQL 쿼리를 실행합니다.
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from salgrade");

			// ResultSetMetaData 객체를 사용하여 쿼리 결과의 컬럼명을 가져옵니다.
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			// 컬럼명을 출력합니다.
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(metaData.getColumnName(i) + " ");
			}
			System.out.println();

			// 4. 쿼리 결과를 처리합니다.
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(rs.getString(i) + " ");
				}
				System.out.println();
			}

			// 5. 사용이 끝난 자원(Connection, Statement, ResultSet)을 close() 메서드를 사용하여 해제합니다.
			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// 드라이버 로드 중 예외가 발생한 경우 처리합니다.
			e.printStackTrace();
		} catch (SQLException e) {
			// 데이터베이스 연결 및 쿼리 실행 중 예외가 발생한 경우 처리합니다.
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// 연결 닫기 중 예외가 발생한 경우 처리합니다.
				e.printStackTrace();
			}
		}
	}
}