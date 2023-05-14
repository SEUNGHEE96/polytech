package service;

import static jdbc.JDBCTemplate.close;
import static jdbc.JDBCTemplate.commit;
import static jdbc.JDBCTemplate.getConnection;
import static jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.HashMap;

import dao.BonusDAO;

public class BonusService{

	private BonusDAO bd = new BonusDAO();

	public HashMap<Integer, Integer> getBonus() {
		Connection conn = getConnection();
		HashMap<Integer, Integer> emplist = bd.empList(conn);
		close(conn);
		return emplist;
	}
	
	public int addBonus(HashMap<Integer, Integer> emplist) {
		Connection conn = getConnection();
		int result = bd.addBonus(conn, emplist);
		//원자성을 유지하기 위해 INSERT문이 제대로 실행되면 COMMIT, 아니면 ROLLBACK을 진행한다.
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
