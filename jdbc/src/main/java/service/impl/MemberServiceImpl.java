package service.impl;

import static jdbc.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	// 삭제 취소용 Member 객체 저장
	private MemberDTO forRollback = null;
	private MemberDAO md = new MemberDAO();

	// 1. loginMember() : 회원 로그인 (이름과 생년월일)
	@Override
	public MemberDTO loginMember(String name, String birthday) {
		Connection conn = getConnection();
		MemberDTO dto = md.loginMember(conn, name, birthday);
		close(conn);
		return dto;
	}

	// 2. selectAll() : 모든 회원 조회
	@Override
	public List<MemberDTO> selectAll() {
		Connection conn = getConnection();
		List<MemberDTO> list = md.selectAll(conn);
		close(conn);
		return list;
	}

	// 3. addMember() : 회원 등록
	@Override
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

	// 4. updateMember() : 회원 수정
	@Override
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

	// 5. deleteMember() : 회원 삭제
	@Override
	public int deleteMember(String name) {
		Connection conn = getConnection();
		int result = 0;
		forRollback = md.saveMember(conn, name);
		if (forRollback != null) {
			result = md.deleteMember(conn, name);
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// 6. rollbackDelete() : 회원 삭제 취소
	@Override
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
