package controller;

import java.util.List;

import dto.MemberDTO;
import message.InputMessage;
import message.OutputMessage;
import service.MemberServiceImpl;
import view.MemberView;

public class MemberController {

	private MemberServiceImpl ms = new MemberServiceImpl();
	private MemberView mv = new MemberView();

	// 1. loginMember() : 회원 로그인 (이름과 생년월일)
	public MemberDTO loginMember() {
		MemberDTO dto = ms.loginMember(mv.inputName(), mv.inputBirthday());
		if (dto == null) {
			System.out.println("로그인에 실패하였습니다.");
		} else {
			System.out.println("로그인에 성공하였습니다.");
		}
		return dto;
		//Controller는 가급적 void로 만들려고 했으나, Main 반복문을 위해 DTO 반환
	}
	
	// 2. selectAll() : 모든 회원 조회
	public void selectAll() {
		List<MemberDTO> list = ms.selectAll();
		for(MemberDTO m : list) {
			System.out.println(m);
		}
	}
	
	// 3. addMember() : 회원 등록
	public void addMember() {
		System.out.println(InputMessage.addMember.getValue());
		List<String> member = mv.inputMember();
		int cnt = ms.addMember(member);
		if (cnt > 0) {
			System.out.println(OutputMessage.addMember.getValue());
		} else {
			System.out.println("등록에 실패하였습니다.");
		}
	}
	
	// 4. updateMember() : 회원 수정
	public void updateMember(int id) {
		List<String> updateContents = mv.updateMember();
		int cnt = ms.updateMember(updateContents, id);
		if (cnt > 0) {
			System.out.println("수정에 성공하였습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	// 5. deleteMember() : 회원 삭제
	public void deleteMember() {
		String name = mv.inputName();
		int cnt = ms.deleteMember(name);
		if (cnt > 0) {
			System.out.println(OutputMessage.deleteMember.getValue());
		} else {
			System.out.println(OutputMessage.failToDelete.getValue());
		}
	}
	
	// 6. rollbackDelete() : 회원 삭제 취소
	public void rollbackDelete() {
		int cnt = ms.rollbackDelete();
		if (cnt > 0) {
			System.out.println(OutputMessage.rollbackMember.getValue());
		} else {
			System.out.println(OutputMessage.failToRollback.getValue());
		}
	}
	
}
