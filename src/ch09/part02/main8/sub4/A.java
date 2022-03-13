package ch09.part02.main8.sub4;

public interface A {
    // method1() 추상 메소드 정의
    public default void method1() {
        System.out.println("interface::A::method1()");
    }
}
