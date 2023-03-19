package palce.domain;

import palce.entity.ConstructionSite;
import palce.entity.TreeShadow;

import java.util.LinkedList;

public class Judgement {
    //공사장 객체 ConstructionSite를 Judge 클래스에 저장한 이유 :
    //조용한 곳인지 시끄러운 곳인지 '판단'할 때에만 공사장 좌표가 필요하므로
    //필요할때마다 호출하거나 매개변수로 받는 것보다 지역변수로 갖고 있는 것이 낫다고 판단
    private ConstructionSite cs;

    public void setConstructionSite(ConstructionSite cs) {
        this.cs = cs;
    }

    enum Status {
        silent, noisy
    }

    //isSilent 메소드는 Judgement 클래스에서만 쓰이므로 private으로 선언
    private boolean isSilent(TreeShadow ts) {
        double leftside = Math.pow((ts.getX() - cs.getX()), 2);
        double rightside = Math.pow((ts.getY() - cs.getY()), 2);
        return (leftside + rightside > Math.pow(cs.getR(), 2));
    }

    public String judgeAllTrees(LinkedList<TreeShadow> treelist) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treelist.size(); i++) {
            TreeShadow ts = treelist.get(i);
            if (isSilent(ts)) {
                sb.append(Status.silent);
            } else if (!isSilent(ts)) {
                sb.append(Status.noisy);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
