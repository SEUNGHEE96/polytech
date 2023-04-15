package dao;

import static jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.MemberDTO;

public class MemberDAO {

	// loginMember() : 이름과 생년월일로 로그인합니다.
	public MemberDTO loginMember(Connection conn, String name, String birthday) {
		MemberDTO dto = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE NAME = ? AND BIRTHDAY = TO_DATE(?,'YYYY/MM/DD')";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, name);
			pt.setString(2, birthday);
			rs = pt.executeQuery();
			if(rs.next()) {
			MemberDTO m = new MemberDTO(rs.getInt("ID"),
					              rs.getString("NAME"),
					              rs.getDate("JOINDATE"),
					              rs.getString("ADDRESS"),
					              rs.getString("PHONENUMBER"),
					              rs.getDate("BIRTHDAY"));
			dto = m;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(pt);
			} catch (SQLException e) {
			}
		}
		return dto;
	}
	
	// selectAll(): 모든 회원을 조회합니다.
	public List<MemberDTO> selectAll(Connection conn) {
		List<MemberDTO> list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER ORDER BY ID";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			MemberDTO m = new MemberDTO(rs.getInt("ID"),
					              rs.getString("NAME"),
					              rs.getDate("JOINDATE"),
					              rs.getString("ADDRESS"),
					              rs.getString("PHONENUMBER"),
					              rs.getDate("BIRTHDAY"));
			list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(st);
				close(rs);
			} catch (SQLException e) {
			}
		}
		return list;
	}
	
	// addMember(): 새로운 회원을 추가합니다.
	public int addMember(Connection conn, List<String> member) {
		PreparedStatement pt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBER(ID, NAME, JOINDATE, ADDRESS, PHONENUMBER, BIRTHDAY, AGE)"
				+ " VALUES (MEMBER_ID.NEXTVAL, ?, TRUNC(SYSDATE), ?, ?, TO_DATE(?,'YYYY/MM/DD'),"
				+ " MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), TRUNC(TO_DATE(?,'YYYY/MM/DD'),'YEAR')) /12 +1)";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, member.get(0));
			pt.setString(2, member.get(1));
			pt.setString(3, member.get(2));
			pt.setString(4, member.get(3));
			pt.setString(5, member.get(3));
			
			result = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(pt);
			} catch (SQLException e) {
			}
		}
		return result;
	}

	// updateMember() : 회원 정보 수정
	public int updateMember(Connection conn, List<String> updateContents, int id) {
		PreparedStatement pt = null;
		int result = 0;
		String sql = null;
		String menu = updateContents.get(0);
		if(menu.equals("BIRTHDAY")) {
	        sql = "UPDATE MEMBER SET BIRTHDAY = TO_DATE(?,'YYYY/MM/DD') WHERE ID = ?";
	    } else {
	        sql = "UPDATE MEMBER SET " + menu + " = ? WHERE ID = ?";
	    }
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, updateContents.get(1));
			pt.setInt(2, id);
			
			result = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(pt);
			} catch (SQLException e) {
			}
		}
		return result;
	}

	// deleteMember(): 회원을 삭제합니다.
	public int deleteMember(Connection conn, String name) {
		PreparedStatement pt = null;
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE NAME = ?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, name);
			
			result = pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(pt);
			} catch (SQLException e) {
			}
		}
		return result;
	}

	// saveMember() : 삭제취소 (추가사항) - 삭제 된 멤버 객체 저장용
	public MemberDTO saveMember(Connection conn, String name) {
		MemberDTO dto = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE NAME = ?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, name);
			rs = pt.executeQuery();
			if(rs.next()) {
			MemberDTO m = new MemberDTO(rs.getInt("ID"),
					              rs.getString("NAME"),
					              rs.getDate("JOINDATE"),
					              rs.getString("ADDRESS"),
					              rs.getString("PHONENUMBER"),
					              rs.getDate("BIRTHDAY"));
			dto = m;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//해당 메소드는 deleteMember 메소드와 함께 쓰이므로 conn.close()를 실행하면
		//java.sql.SQLRecoverableException: ORA-17008: 접속을 해제했습니다.
		//해당 오류가 납니다. 따라서 커넥션을 해제하지 않고 유지합니다.
		return dto;
	}
	
	// rollbackdelete() : 삭제취소 (추가사항) - 재삽입용
	public int rollbackDelete(Connection conn, MemberDTO forRollback) {
		PreparedStatement pt = null;
		int result = 0;
		String sql = "INSERT INTO MEMBER(ID, NAME, JOINDATE, ADDRESS, PHONENUMBER, BIRTHDAY, AGE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, forRollback.getId());
			pt.setString(2, forRollback.getName());
			pt.setDate(3, forRollback.getJoinDate());
			pt.setString(4, forRollback.getAddress());
			pt.setString(5, forRollback.getPhoneNumber());
			pt.setDate(6, forRollback.getBirthday());
			pt.setInt(7, forRollback.getAge());
			
			result = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(pt);
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
}