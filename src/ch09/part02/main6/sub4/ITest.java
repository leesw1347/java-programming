package ch09.part02.main6.sub4;

public interface ITest {
    /**
     * 인터페이스는 상속과 같이 해당 default 함수를 상속하여 사용할 수 있다.
     * default 함수 정의
     * 재정의를 필수가 아닌 선택으로 할 수 있다
     * 재정의 하지 않을 경우, 상속과 같이 부모가 제공한 인터페이스의 default 함수로 로직이 적용된다
     */
    public default void method1() {
        System.out.println("ITest default 함수사용 - " + this.getClass().getName());
    }

    public static void method2() {
        // static 함수는 재정의(Override)가 불가능하다
        System.out.println("ITest static 함수사용 - method2()");
    }

    /**
     * private 함수 정의
     */
    private void method4(){
        System.out.println("자바1.9 버전 : private 메소드 실행");
    }

    /**
     * static 함수 정의
     */
    public static void method5(){
        System.out.println("static method5() 함수실행");
        System.out.println("private static method5() 함수 호출 가능");
        method5();
    }

    /**
     * private static 함수 정의
      */
    private static void method6(){
        System.out.println("자바1.9 버전 : private static 메소드 실행");
    }

    /**
     * private 메소드
     *  private 함수의 경우 반드시 로직을 구현해야 한다
     *  외부에서는 private 함수를 호출 불가능, 인터페이스 내에서 사용하기 위해서 정의
     *  default 메소드에서 private 함수 또는 private static 함수를 호출 할 수 있다
     *  static 함수에서 private static 함수를 호출할 수 있다
     */
    public default void method3() {
        System.out.println("default method3() 함수 실행");

        System.out.println("private method4() 함수 실행");
        method4();

        System.out.println("private static void method5() 함수 실행");
        method6();
    }
}
