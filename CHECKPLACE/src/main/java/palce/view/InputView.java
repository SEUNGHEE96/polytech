package palce.view;

import palce.entity.ConstructionSite;
import palce.entity.TreeShadow;

import java.util.LinkedList;
import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public ConstructionSite saveConstructionSite() {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int R = scanner.nextInt();
        validate(a, b, R);
        return new ConstructionSite(a, b, R);
    }

    public int countTree() {
        int cnt = scanner.nextInt();
        validate(cnt);
        return cnt;
    }

    public LinkedList<TreeShadow> saveTreeShadow(int cnt) {
        LinkedList<TreeShadow> treelist = new LinkedList<>();
        for (int i = 0; i < cnt; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            validate(x, y);
            treelist.add(new TreeShadow(x, y));
        }
        return treelist;
    }

    //Q. 예외처리는 어떤 클래스에서 하는 것이 가장 이상적인지...?
    private void validate(int... nums) {
        for(int n : nums) {
            if(n < 0) {
                throw new IllegalArgumentException("[ERROR] 유효한 값을 입력하세요!");
            }
        }
    }

}
