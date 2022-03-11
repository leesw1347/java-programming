package ch09.part01.main5;

public class TestMain {
    /**
     * Parent 객체 생성 -> method(), method2() 함수 호출
     * Child 객체 생성 -> method1(), method2() 함수 호출
     */
    public static void main(String[] args) {
        /**
         * Parent 객체 생성
         */
        Parent p = new Parent();
        p.method1("1");
        p.method2("2");
        p.method3("3");

        /**
         * Child 객체 생성
         */
        Child c = new Child();
        c.method1("4");
        c.method2("5");
        c.method3("6");
        c.method4("7");
    }
}
