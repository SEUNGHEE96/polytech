package shadow.entity;

public class ConstructionSite extends Coordinate {

    private int R;

    public ConstructionSite(int a, int b, int R) {
        super(a,b);
        this.R = R;
    }

    public int getR() {
        return R;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
