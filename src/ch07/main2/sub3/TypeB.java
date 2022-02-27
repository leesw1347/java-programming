package ch07.main2.sub3;

/**
 * TypeB 클래스는 TypeA 클래스를 상속
 */
public class TypeB extends TypeA {
    /**
     * TypeB 클래스는 TypeA 클래스가 가지는 클래스 구성요소를 모두 갖는다
     * TypeB 클래스만의 속성과 기능을 가질 수 있다.
     */
    private int value = 1;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
