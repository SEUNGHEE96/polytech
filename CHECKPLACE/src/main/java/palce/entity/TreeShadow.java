package palce.entity;

import java.util.Objects;

public class TreeShadow {
    private int x;
    private int y;
    //Q. 공사장 위치를 그늘 객체의 필드로 갖고 있는 것이 괜찮은 방향인가?
    //넣은 이유는 silent인지 noisy인지 비교하는 메서드를 만들었을 때,
    //매번 파라미터로 공사장 좌표를 넣어주는 것보다,
    //그늘 객체 자체가 필드로 갖고 있는 편이 연산에 낫지 않을까? 하는 생각에 넣어보았다
    private ConstructionSite constructionSite;

    public TreeShadow(int x, int y, ConstructionSite constructionSite) {
        this.x = x;
        this.y = y;
        this.constructionSite = constructionSite;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ConstructionSite getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSite constructionSite) {
        this.constructionSite = constructionSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeShadow that)) return false;
        return getX() == that.getX() && getY() == that.getY() && Objects.equals(getConstructionSite(), that.getConstructionSite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getConstructionSite());
    }

    @Override
    public String toString() {
        return "TreeShadow{" +
                "x=" + x +
                ", y=" + y +
                ", constructionSite=" + constructionSite +
                '}';
    }

}
