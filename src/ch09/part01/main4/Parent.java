package ch09.part01.main4;

// 부모 클래스 속성 및 함수의 접근 - super, protected
public class Parent {
    /**
     * name, value, type 전역변수 정의
     * enum 타입 정의
     */
    protected String name = "parent";
    public int value = 1;
    private Type type = Type.A;

    /**
     * enum 타입 정의
     */
    public enum Type {
        A,B,C,D
    };
}