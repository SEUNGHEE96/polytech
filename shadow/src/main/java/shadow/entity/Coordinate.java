package shadow.entity;

public class Coordinate {
    //인터페이스 혹은 추상클래스로 선언하지 않은 이유 :
    //x, y좌표 값을 갖고 있는 것이 똑같고, get 메소드가 필요한 것이 똑같은데
    //굳이 추상메소드나 인터페이스처럼 메소드 이름만 명명하고
    //구체적인 내용을 해당 객체에서 구현하느니, 부모클래스에서 완성하고 상속받는 것이 중복 제거에 낫다고 생각했음.
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //setter 메소드는 전부 지움!
    //생성자로 인스턴스를 생성한 후에는 좌표값이 바뀌지 않는 것이 맞다고 생각하여 삭제

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
