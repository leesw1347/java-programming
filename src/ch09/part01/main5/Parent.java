package ch09.part01.main5;

public class Parent {
    /**
     * method1() 부모 함수 정의
     * method2() 부모 함수 정의
     * 'final' method3() 부모 함수 정의 (자식 클래스 재정의 불가능)
     */

    public void method1(String msg) {
        System.out.println(msg + "\t부모함수 method1()");
    }

    public void method2(String msg) {
        System.out.println(msg + "\t부모함수 method2()");
    }

    /**
     * final, method3() 부모함수 정의 - 자식클래스 재정의 불가능
     */
    public final void method3(String msg) {
        System.out.println(msg + "\t부모함수 method4()");
    }
}