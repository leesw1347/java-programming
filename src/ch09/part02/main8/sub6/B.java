package ch09.part02.main8.sub6;

public class B implements A {
    @Override
    public void method1() {
        A.super.method1();
    }

    // method2 추상 메소드 정의
    public void method2() {
        System.out.println("B 클래스 method2() 실행");
    }
}
