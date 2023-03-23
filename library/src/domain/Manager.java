package domain;

import java.util.List;
import java.util.Scanner;

import save.MakeList;
import view.InputView;

public class Manager<E> {
	
	Scanner sc = new Scanner(System.in);
	InputView iv = new InputView();
	MakeList ml = new MakeList();
	//각 Entity의 list
	List<E> list;
	
	//각 list 전체 조회
	public void printAllList() {
		for(E e : list) {
			System.out.println(e);
		}
	}
	
	//하위 클래스에서 Manager에서 갖고있는 list를 가져오기 위한 메소드
	public List<E> getList() {
		return list;
	}
	
}
