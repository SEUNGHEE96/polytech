package controller;

import java.util.List;

import dto.MemberDTO;
import service.impl.MemberServiceImpl;
import message.InputMessage;
import view.MemberView;

public class MemberController extends Controller{

	private MemberServiceImpl ms = new MemberServiceImpl();
	private MemberView mv = new MemberView();

	// 1. loginMember() : 회원 로그인 (이름과 생년월일)
	public MemberDTO loginMember() {
		MemberDTO dto = ms.loginMember(mv.inputName(), mv.inputBirthday());
		int result = 0;
		if (dto != null) {
			result = 1;
		}
		mv.successOrFail(result, "로그인");
		return dto;
		// Controller는 가급적 void로 만들려고 했으나, Main 반복문을 위해 DTO 반환
	}

	// 2. selectAll() : 모든 회원 조회
	public void selectAll() {
		List<MemberDTO> list = ms.selectAll();
		mv.printAll(list);
	}

	// 3. addMember() : 회원 등록
	public void addMember() {
		System.out.println(InputMessage.addMember.getValue());
		List<String> member = mv.inputMember();
		int cnt = ms.addMember(member);
		mv.successOrFail(cnt, "등록");
	}

	// 4. updateMember() : 회원 수정
	public void updateMember(int id) {
		List<String> updateContents = mv.updateMember();
		int cnt = ms.updateMember(updateContents, id);
		mv.successOrFail(cnt, "수정");
	}

	// 5. deleteMember() : 회원 삭제
	public void deleteMember() {
		String name = mv.inputName();
		int cnt = ms.deleteMember(name);
		mv.successOrFail(cnt, "삭제");
	}

	// 6. rollbackDelete() : 회원 삭제 취소
	public void rollbackDelete() {
		int cnt = ms.rollbackDelete();
		mv.successOrFail(cnt, "취소");
	}

}
