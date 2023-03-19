package palce.entity;

import java.util.Objects;

public class ConstructionSite {

    private int a;
    private int b;
    private int R;

    public ConstructionSite(int a, int b, int R) {
        this.a = a;
        this.b = b;
        this.R = R;
    }

    //setter 메소드는 전부 지움!
    //생성자로 인스턴스를 생성한 후에는 좌표값이 바뀌지 않는 것이 맞다고 생각하여 삭제
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getR() {
        return R;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConstructionSite that)) return false;
        return getA() == that.getA() && getB() == that.getB() && getR() == that.getR();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), getR());
    }

    @Override
    public String toString() {
        return "ConstructionSite{" +
                "a=" + a +
                ", b=" + b +
                ", R=" + R +
                '}';
    }

}
