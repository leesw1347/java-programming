package ch09.part02.main8.sub2;

public interface IParent {
    /**
     * 추상 메소드 정의 : method1()
     * method2() default 메소드 정의
     * method3() default 메소드 정의
     */

    public void method1();

    public default void method2() {
        System.out.println("IParent default method2() 함수호출");
    }

    public default void method3() {
        System.out.println("IParent default method3() 함수호출");
    }
}