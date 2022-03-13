package ch09.part02.main6.sub4;

public class TestImpl implements ITest {
    public static void main(String[] args) {
        TestImpl test = new TestImpl();
        /**
         * default 함수 사용
         */
        test.method1();
        ITest.method2();
        test.method3();

    }
}
