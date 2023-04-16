package service;

import java.util.List;

import dto.MemberDTO;

public interface MemberService {

	// 1. loginMember() : 회원 로그인 (이름과 생년월일)
	MemberDTO loginMember(String name, String birthday);

	// 2. selectAll() : 모든 회원 조회
	List<MemberDTO> selectAll();

	// 3. addMember() : 회원 등록
	int addMember(List<String> member);

	// 4. updateMember() : 회원 수정
	int updateMember(List<String> updateContents, int id);

	// 5. deleteMember() : 회원 삭제
	int deleteMember(String name);

	// 6. rollbackDelete() : 회원 삭제 취소
	int rollbackDelete();

}
