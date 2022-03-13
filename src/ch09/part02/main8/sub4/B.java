package ch09.part02.main8.sub4;

public class B implements A{
    // method1() 함수 재정의
    @Override
    public void method1() {
//        A.super.method1();
        System.out.println("B 클래스 method1() 실행");
    }
}
