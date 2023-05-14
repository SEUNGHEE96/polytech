package dao;

import static jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BonusDAO {
	
	// 1. empList() : 경영자와 애널리스트를 제외한 모든 사원 + 담당 고객수(10만까지) HashMap에 저장
	public HashMap<Integer, Integer> empList(Connection conn) {
	    HashMap<Integer, Integer> emp = new HashMap<Integer, Integer>();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    PreparedStatement ps2 = null;
	    ResultSet rs2 = null;
	    
	    int pageSize = 1000; // 한 번에 가져올 데이터 양
	    Set<Integer> keys = new HashSet<Integer>(); //빠른 연산을 위한 key값 저장

	    //두 쿼리문 모두 필요한 컬럼만 조회한다.
	    String sql = "SELECT EMPNO,JOB FROM EMP";
	    String sql2 = "SELECT MGR_EMPNO FROM CUSTOMER";
	    try {
	        ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	        ps.setFetchSize(pageSize);
	        rs = ps.executeQuery();
	        while (rs.next()) {
				//PRESIDENT와 ANALYST는 저장하지 않는다.
	        	if(rs.getString("JOB").equals("PRESIDENT") || rs.getString("JOB").equals("ANALYST")) {
					continue;
				} else {
					int empno = rs.getInt("EMPNO");
					keys.add(empno);
					emp.put(empno, 0);
				}
			}

	        ps2 = conn.prepareStatement(sql2, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	        ps2.setFetchSize(pageSize);
	        rs2 = ps2.executeQuery();
	        
	        while (rs2.next()) {
				int empno = rs2.getInt("MGR_EMPNO");
				//만약 모두 10만이 넘어서 SET에 데이터가 없다면 반복문을 종료한다. (=570만건 전부 조회할 필요 X)
				if(keys.isEmpty()) {
					break;
				} else if (emp.containsKey(empno)) {
					int customer = emp.get(empno);
					//HASHMAP에 저장한 고객수가 10만이 넘으면 SET에서 삭제한다. (=더 이상 카운트하지 않는다)
					if (customer > 100000) {
						keys.remove(empno);
					} else {
						//HASHMAP에서 회원 수 조회한 후 값을 1 늘려준다.
						emp.replace(empno, customer+1);					
					}
				//EMPNO가 EMP에 없다면 (=JOB이 PRESIDENT 혹은 ANALYST라면) 다시 반복문으로 올라간다.
				} else if (!emp.containsKey(empno)) {
					continue;
				}
			}
	        
	        /*
	        while (rs2.next()) {
	            int empno = rs2.getInt("MGR_EMPNO");
	            if (keys.contains(empno)) {
	                int customer = emp.get(empno);
	                if (customer > 100000) {
	                    bonus += 1000;
	                    keys.remove(empno);
	                } else {
	                    emp.replace(empno, customer+1);                  
	                }
	            }
	        }
	        */

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conn.close();
	            close(ps);
	        } catch (SQLException e) {
	        }
	    }
	    return emp;
	}
	
	// 2. addBonus() : 회원 등록
	public int addBonus(Connection conn, HashMap<Integer, Integer> emp) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO BONUS(YYYYMM, EMPNO, BONUS_SAL) VALUES ('202306', ?, ?)";
		try {
			Set<Integer> keys = emp.keySet();
			for(int empno : keys) {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, empno);
				//담당한 고객이 10만 이상이라면 보너스는 2000
				if(emp.get(empno) > 100000) {
					ps.setInt(2, 2000);	
				//아니라면 보너스는 1000
				} else {
					ps.setInt(2, 1000);	
				}
				result = ps.executeUpdate();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(ps);
			} catch (SQLException e) {
			}
		}
		return result;
	}
}
