package ch03.part09.main4;

public class Parent {
    public void testMethod1() {
        System.out.println("testMethod1 함수호출");
    }

    public void testMethod2() {
        System.out.println("testMethod2 함수 호출");
    }

    /**
     * 함수에 final을 명시하여 해당 함수를 더이상 Override 되지 않도록 함
     */
    public final void testMethod3() {
        System.out.println("testMethod3 함수 호출");
    }
}