package domain;

import java.util.Collections;

import entity.Book;
import entity.Member;

public class MemberManager extends Manager<Member> {

	Member forRollback = null;
	// list = ml.memberlist(); 가 있음

	public MemberManager() {
		// Makelist 클래스의 memberlist 메서드를 호출하여 반환된 리스트를 list 필드에 할당합니다.
		list = ml.memberlist();
	}

	@Override
	public void printAllList() {
		Collections.sort(list); // id 기준으로 정렬
		for (Member m : list) {
			System.out.println(m);
		}
	}

	// addMember(): 새로운 회원을 추가합니다.
	public void addMember(Member member) {
		int id = list.get(list.size() - 1).getId() + 1;
		member.setId(id);
		list.add(member);
	}

	// editMember() : 회원수정
	public void editMember(int id, Member member) {
		for (Member mem : list) {
			if (mem.getId() == id) {
				list.set(list.indexOf(mem), member);
				break;
			}
		}
	}

	// - deleteMember(): 회원을 삭제합니다.
	public boolean deleteMember(int id) {
		boolean result = false;
		for (Member mem : list) {
			if (mem.getId() == id) {
				list.remove(mem);
				forRollback = mem;
				result = true;
				break;
			}
		}
		return result;
	}

	// rollbackdelete() : 삭제취소 ((추가사항))
	public boolean rollbackDelete() {
		boolean result = true;
		if (forRollback == null) {
			return false;
		}
		list.add(forRollback);
		forRollback = null;
		return result;
	}
}
