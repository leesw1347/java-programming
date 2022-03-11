package ch09.part01.main5;

public class Child extends Parent {
    /**
     * method1() 부모 함수 재정의 (Override)
     * method3() 자식 함수 정의
     * -> 자식 함수에서 부모 함수 호출 - super
     */

    /**
     * method1() 부모함수 재정의(Override)
     */
    @Override
    public void method1(String msg) {
//        super.method1(msg);
        System.out.println(msg + "\t재정의 된 자식함수 method1()");
    }

    /**
     * method3() 자식함수 정의
     */
    public void method4(String msg) {
        System.out.println(msg + "\t자식함수 method4() 호출 시작---");
        /**
         * 자식함수에서 부모함수 호출 - super
         */
        method1(msg + " -1");
        super.method1(msg + "-2"); // 부모함수 method1() 호출
        super.method2(msg + "-3"); // 부모함수 method2() 호출
        super.method3(msg + "-4"); // 부모함수 method3() 호출
        System.out.println(msg + "\t자식함수 method4() 호출종료");
    }
}
