package palce;

import palce.domain.Judgement;
import palce.entity.ConstructionSite;
import palce.entity.TreeShadow;
import palce.view.InputView;
import palce.view.OutputView;

import java.util.LinkedList;

public class Main {
    static InputView inputView = new InputView();
    static Judgement judgement = new Judgement();
    static OutputView outputView = new OutputView();
    public static void main(String[] args) {
        //1. 공사 현장의 좌표를 inputView를 통해 입력받는다.
        ConstructionSite cs = inputView.saveConstructionSite();
        //2. 나무 그늘의 수를 입력 받는다.
        int cnt = inputView.countTree();
        //3. 위에서 입력한 수 만큼 나무 그늘의 좌표를 입력받는다.
        LinkedList<TreeShadow> treelist = inputView.saveTreeShadow(cnt, cs);
        //4. 독서에 적합한 곳인지 판별하고 그 결과를 저장한다.
        String result = judgement.judgeAllTrees(treelist);
        //5. 그 결과를 출력한다.
        outputView.printReulst(result);
    }

}