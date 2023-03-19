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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
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
