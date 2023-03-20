package shadow.view;

import shadow.entity.ConstructionSite;
import shadow.entity.TreeShadow;

import java.util.LinkedList;
import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public ConstructionSite saveConstructionSite() {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int R = scanner.nextInt();
        return new ConstructionSite(a, b, R);
    }

    public int countTree() {
        int cnt = scanner.nextInt();
        return cnt;
    }

    public LinkedList<TreeShadow> saveTreeShadow(int cnt) {
        LinkedList<TreeShadow> treelist = new LinkedList<>();
        for (int i = 0; i < cnt; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            treelist.add(new TreeShadow(x, y));
        }
        return treelist;
    }

}
