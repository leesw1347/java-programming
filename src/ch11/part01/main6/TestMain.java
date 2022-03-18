package ch11.part01.main6;

public class TestMain {
    // 변수명이 같을 경우 변수의 접근 우선순위를 이해할 수 있다.
    // 내부 클래스 내에서 외부 클래스, 전역변수, 익명클래스 전역변수, 지역변수를 구분할 수 있다
    private static String name = "TestMain 정적 전역변수 name";
    private static String name2 = "TestMain 정적 전역변수 name2";

    public void method() {
        InnerClass c = new InnerClass() {
            @Override
            public void method2() {
                System.out.println("InnerClass method2() 재정의");

                // 문제1. TestMain 클래스 전역변수 name
                System.out.println(TestMain.name);

                // 문제2. InnerClass 클래스 전역변수 name
                System.out.println(InnerClass.name);

                // 문제3. InnerClass 클래스 지역변수 name
                System.out.println(InnerClass.name);

                // 문제4. TestMain 클래스 전역변수 name2
                System.out.println(TestMain.name2);

                // InnerClass 클래스 전역변수 name2
//                System.out.println(InnerClass.name2);

            }
        };
        c.method2();
    }

    public abstract static class InnerClass {
        private static String name = "InnerClass 정적 전역변수 name";
        private String name2 = "InnerClass 전역변수 name2";

        public abstract void method2();
    }

    public static void main(String[] args) {
        new TestMain().method();
    }
}
