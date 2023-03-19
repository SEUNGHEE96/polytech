package palce.domain;

import palce.entity.TreeShadow;

import java.util.LinkedList;

public class Judgement {

    public boolean isSilent(TreeShadow ts) {
        double distance = Math.pow((ts.getX() - ts.getConstructionSite().getA()), 2) + Math.pow((ts.getY() - ts.getConstructionSite().getB()), 2);
        return (distance > Math.pow(ts.getConstructionSite().getR(), 2));
    }

    public String judgeAllTrees(LinkedList<TreeShadow> treelist) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< treelist.size(); i++) {
            TreeShadow ts = treelist.get(i);
            if(isSilent(ts)){
                sb.append(Status.silent);
                sb.append("\n");
            } else {
                sb.append(Status.noisy);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    enum Status {
        silent, noisy
    }

}
