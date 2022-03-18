package ch11.part01.main3;


/**
 * 호출 위치가 익명 클래스의 함수 내부일 때 호출 최소 구분
 *  1. TestMain 전역변수 : TestMain.this.name
 *  2. TestMain 지역변수 : 접근 불가능
 *  3. 익명 클래스 전역변수 : this.name
 *  4. 익명 클래스 지역변수 : name
 */
public class TestMain {
    // 변수명이 같을 경우 변수의 접근 우선 순위를 이해할 수 있다
    // 내부 클래스 내에서 외부 클래스, 전역변수, 익명 클래스 전역변수, 지역변수를 구분할 수 있다

    // TestMain 전역변수 name 정의
    // ch11.part01.main3.TestMain.this.name
    private String name = "TestMain 전역변수 name"; // 변수1

    // method() 함수 정의
    public void method() {
        // 지역변수 name 정의
        String name = "method() 함수 지역변수 name"; // 변수2

        // 익명클래스
        ITest iTest = new ITest() {
            // 익명클래스 전역변수 name 정의
            private String name = "익명클래스 전역변수 name"; // 변수3

            // method2() 함수 재정의
            @Override
            public void method2() {
                /**
                 * 내부 클래스의 함수 내에서 변수명이 중복될 경우 우선 순위는 해당 블록에 가까운 변수부터 호출한다
                 * [익명클래스] 지역변수 -> [익명클래스] 전역변수 -> [AccessTest03] 전역변수
                 */

                // 지역변수 name 정의
                String name = "method2() 함수 지역변수 name"; // 변수4

                System.out.println(TestMain.this.name); // 문제1
                System.out.println(); // 문제2 익명클래스 내의 지역변수와 중복되어 접근불가
                System.out.println(this.name); // 문제3
                System.out.println(name); // 문제4
            }
        };
    }

    // 인터페이스 정의
    public interface ITest {
        public void method2();
    }

    // 메인함수 정의
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.method();
    }
}
