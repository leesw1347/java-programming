package ch11.part01.main2;

public class TestMain {

    // 전역변수 정의
    // ch11.part01.main2.TestMain.this.name
    private String name = "TestMain 전역변수 name."; // 변수1

    // 내부클래스 정의
    public class innerClass {
        // 내부 클래스 전역변수 정의
        // ch11.part01.main2.TestMain.innerClass.this.name
        private String name = "InnerClass 전역변수 name"; // 변수2

        // method() 함수 정의
        private void method() {
            // 지역변수 정의
            String name = "method() 지역변수 name"; // 변수3

            //                System.out.println(Class.forName(TestMain).getDeclaredField("name"));
            System.out.println(TestMain.this.name); // 문제1
            System.out.println(this.name); // 문제2
            System.out.println(name); // 문제3
        }
    }

    public static void main(String[] args) {
        // 객체생성 및 함수 호출
        TestMain testMain = new TestMain();
        testMain.new innerClass().method();
    }
}
