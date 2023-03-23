package domain;

import java.util.List;
import java.util.Scanner;

import save.MakeList;
import view.InputView;

public class Manager<E> {
	
	Scanner sc = new Scanner(System.in);
	InputView iv = new InputView();
	MakeList ml = new MakeList();
	List<E> list;
	
	public void printAllList() {
		for(E e : list) {
			System.out.println(e);
		}
	}

	public List<E> getList() {
		return list;
	}
	
}
