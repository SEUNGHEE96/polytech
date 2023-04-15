package service;

import static jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberServiceImpl {
	
	//삭제 취소용 Member 객체 저장
	private MemberDTO forRollback = null;
	private MemberDAO md = new MemberDAO();
	
	// loginMember() : 회원 로그인 (이름과 생년월일)
	public MemberDTO loginMember(String name, String birthday) {
		Connection conn = getConnection();
		MemberDTO dto = md.loginMember(conn, name, birthday);
		close(conn);
		return dto;
	}

	// selectAll() : 모든 회원 조회
	public List<MemberDTO> selectAll() {
		Connection conn = getConnection();
		List<MemberDTO> list = md.selectAll(conn);
		close(conn);
		return list;
	}

	// addMember() : 회원 등록
	public int addMember(List<String> member) {
		Connection conn = getConnection();
		int result = md.addMember(conn, member);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	// updateMember() : 회원 수정
	public int updateMember(List<String> updateContents, int id) {
		Connection conn = getConnection();
		int result = md.updateMember(conn, updateContents, id);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	// deleteMember() : 회원 삭제
	public int deleteMember(String name) {
		Connection conn = getConnection();
		int result = 0;
		forRollback = md.saveMember(conn, name);
		if(forRollback != null) {
			result = md.deleteMember(conn, name);
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// rollbackDelete() : 회원 삭제 취소
	public int rollbackDelete() {
		Connection conn = getConnection();
		int result = 0;
		if (forRollback == null) {
			result = -1;
		} else {
			result = md.rollbackDelete(conn, forRollback);
			if (result > 0) {
				forRollback = null;
				commit(conn);
			} else {
				rollback(conn);
			}			
		}
		close(conn);
		return result;
	}
	
}
