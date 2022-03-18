package ch11.part01.main4;

/**
 * 변수명이 같을 경우 변수의 접근 우선 순위를 이해할 수 있다.
 * 내부 클래스 내에서 외부 클래스 전역변수, 익명 클래스 전역변수, 지역변수를 구분할 수 있다
 */
public class TestMain {
    /* TestMain 전역변수 name 정의 */
    private String name = "TestMain 전역변수 name"; // 변수1

    // method() 함수 정의
    private void method() {
        // 지역변수 name 정의
        String name = "method() 함수 지역변수 name"; // 변수2
        ITest itest = new ITest() {
            // 익명 클래스 전역변수 name 정의
            private String name = "익명클래스 전역변수 name"; // 변수3

            // method2() 함수 재정의
            @Override
            public void method2() {
                // 지역변수 name 정의
                String name = "method2() 함수 지역변수 name"; // 변수4
//                ITest.super.method2();

                System.out.println(TestMain.this.name);//문제1
                System.out.println(); // 문제2 변수 출력 못함
                System.out.println(this.name); //문제3
                System.out.println(name); //문제4
            }
        };
    }

    public interface ITest {
        public default void method2() {
            System.out.println("ITest Default interface");
        }
    }
}
