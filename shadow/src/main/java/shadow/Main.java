package shadow;

import shadow.domain.Judgement;
import shadow.entity.ConstructionSite;
import shadow.entity.TreeShadow;
import shadow.view.InputView;
import shadow.view.OutputView;

import java.util.LinkedList;

public class Main {
    //개인적으로 중점을 뒀던 부분 : main 클래스 외에 다른 클래스(ex 도메인)에서는 view를 받지 않는다.
    private static InputView inputView = new InputView();
    private static Judgement judgement = new Judgement();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        //1. 공사 현장의 좌표를 inputView를 통해 입력받는다.
        ConstructionSite cs = inputView.saveConstructionSite();
        //2. Judgement 클래스에 공사장 인스턴스(=좌표)를 저장한다.
        judgement.setConstructionSite(cs);
        //3. 나무 그늘의 수를 입력 받는다.
        int cnt = inputView.countTree();
        //4. 위에서 입력한 수 만큼 나무 그늘의 좌표를 입력받는다.
        LinkedList<TreeShadow> treelist = inputView.saveTreeShadow(cnt);
        //5. 독서에 적합한 곳인지 판별하고 그 결과를 저장한다.
        String result = judgement.judgeAllTrees(treelist);
        //6. 그 결과를 출력한다.
        outputView.printResult(result);
    }

}