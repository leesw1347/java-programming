package ch09.part03.main3;

public abstract class AbstractClass {
    // 정적(static) 전역변수 정의
    private static String var1 = "static 전역변수";

    // 정적(static) 초기화 블록 정의
    {
        System.out.println("\t추상클래스 - var1[" + var1 + "]");
    }

    // 전역변수 정의
    private String var2 = "전역변수";

    // 초기화 블록 정의
    {
        System.out.println("\t추상클래스 - var2[" + var2 + "]");
    }

    // 생성자 함수 정의
    public AbstractClass() {
        System.out.println("\t추상클래스 - 생성자함수");
        method1();
    }

    // method1() 추상 메소드 정의
    public abstract void method1();
}
