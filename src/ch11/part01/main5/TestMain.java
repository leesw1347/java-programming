package ch11.part01.main5;

public class TestMain {
    // 함수 내 익명 클래스가 존재할 때 함수 내부의 지역변수를 익명클래스에 접근 방법과
    // 주의사항을 이해할 수 있다
    private void method() {
        // 지역변수를 접근시키기 위해서는 final 키워드를 사용해야 한다
        String name = "method() 함수 지역변수 name"; // 변수1

        // 익명클래스
        ITest iTest = new ITest() {
            @Override
            public void method() {
//                ITest.super.method();
//                name = "111"; java1.8 이상부터는 final 키워드를 생략할 수 있지만, 값의 변경은 불가능하다
                System.out.println(name); // 문제1
            }
        };
        iTest.method();

    }

    public interface ITest {
        public default void method() {
            System.out.println("ITest Intertface 기본 메소드 호출");
        }
    }

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.method();
    }
}
