package palce.domain;

import palce.entity.ConstructionSite;
import palce.entity.TreeShadow;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public ConstructionSite saveConstructionSite() {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int R = scanner.nextInt();
        return new ConstructionSite(a, b, R);
    }

    public int countTree() {
        return scanner.nextInt();
    }

    public TreeShadow saveTreeShadow(ConstructionSite constructionsite) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new TreeShadow(x, y, constructionsite);
    }

}
