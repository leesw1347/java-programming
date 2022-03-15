package ch09.part03.main3;

public class ChildClass extends AbstractClass {
    // 정적(static) 전역변수 정의
    private static String var3 = "static 전역변수";

    // 1. 정적(static) 초기화 블록 정의
    static {
        System.out.println("\t구현클래스 - var3[" + var3 + "]");
    }

    // 전역변수 정의
    private String var4 = "전역변수";

    // 초기화 블록 정의
    {
        System.out.println("\t구현클래스 - var4[" + var4 + "]");
    }

    // 생성자 함수 정의
    public ChildClass() {
        System.out.println("\t구현클래스 - 생성자함수");
    }

    // method1() 추상 메소드 재정의
    @Override
    public void method1() {
        System.out.println("\t구현클래스 - method1() - var4["+var4+"]");
    }
}
