package dao;

import static jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

public class MemberDAO {

	// 1. loginMember() : 회원 로그인 (이름과 생년월일)
	public MemberDTO loginMember(Connection conn, String name, String birthday) {
		MemberDTO dto = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE NAME = ? AND BIRTHDAY = TO_DATE(?,'YYYY/MM/DD')";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, birthday);
			rs = ps.executeQuery();
			if (rs.next()) {
				MemberDTO m = new MemberDTO(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("JOINDATE"),
						rs.getString("ADDRESS"), rs.getString("PHONENUMBER"), rs.getDate("BIRTHDAY"));
				dto = m;
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
		return dto;
	}

	// 2. selectAll() : 모든 회원 조회
	public List<MemberDTO> selectAll(Connection conn) {
		List<MemberDTO> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER ORDER BY ID";
		try {
			ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO m = new MemberDTO(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("JOINDATE"),
						rs.getString("ADDRESS"), rs.getString("PHONENUMBER"), rs.getDate("BIRTHDAY"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				close(ps);
				close(rs);
			} catch (SQLException e) {
			}
		}
		return list;
	}

	// 3. addMember() : 회원 등록
	public int addMember(Connection conn, List<String> member) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO MEMBER(ID, NAME, JOINDATE, ADDRESS, PHONENUMBER, BIRTHDAY, AGE)"
				+ " VALUES (MEMBER_ID.NEXTVAL, ?, TRUNC(SYSDATE), ?, ?, TO_DATE(?,'YYYY/MM/DD'),"
				+ " MONTHS_BETWEEN(TRUNC(SYSDATE,'YEAR'), TRUNC(TO_DATE(?,'YYYY/MM/DD'),'YEAR')) /12 +1)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.get(0));
			ps.setString(2, member.get(1));
			ps.setString(3, member.get(2));
			ps.setString(4, member.get(3));
			ps.setString(5, member.get(3));

			result = ps.executeUpdate();
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

	// 4. updateMember() : 회원 수정
	public int updateMember(Connection conn, List<String> updateContents, int id) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = null;
		String menu = updateContents.get(0);
		if (menu.equals("BIRTHDAY")) {
			sql = "UPDATE MEMBER SET BIRTHDAY = TO_DATE(?,'YYYY/MM/DD') WHERE ID = ?";
		} else {
			sql = "UPDATE MEMBER SET " + menu + " = ? WHERE ID = ?";
		}
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, updateContents.get(1));
			ps.setInt(2, id);

			result = ps.executeUpdate();
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

	// 5. deleteMember() : 회원 삭제
	public int deleteMember(Connection conn, String name) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE NAME = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);

			result = ps.executeUpdate();

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

	// 6. rollbackDelete() : 회원 삭제 취소 (추가사항) - 재삽입용
	public int rollbackDelete(Connection conn, MemberDTO forRollback) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO MEMBER(ID, NAME, JOINDATE, ADDRESS, PHONENUMBER, BIRTHDAY, AGE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, forRollback.getId());
			ps.setString(2, forRollback.getName());
			ps.setDate(3, forRollback.getJoinDate());
			ps.setString(4, forRollback.getAddress());
			ps.setString(5, forRollback.getPhoneNumber());
			ps.setDate(6, forRollback.getBirthday());
			ps.setInt(7, forRollback.getAge());

			result = ps.executeUpdate();
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

	// 7. saveMember() : 삭제 취소 (추가사항) - 삭제 된 멤버 객체 저장용
	public MemberDTO saveMember(Connection conn, String name) {
		MemberDTO dto = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE NAME = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				MemberDTO m = new MemberDTO(rs.getInt("ID"), rs.getString("NAME"), rs.getDate("JOINDATE"),
						rs.getString("ADDRESS"), rs.getString("PHONENUMBER"), rs.getDate("BIRTHDAY"));
				dto = m;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 해당 메소드는 deleteMember 메소드와 함께 쓰이므로 conn.close()를 실행하면
		// java.sql.SQLRecoverableException: ORA-17008: 접속을 해제했습니다.
		// 해당 오류가 납니다. 따라서 커넥션을 해제하지 않고 유지합니다.
		return dto;
	}

}
