package ch09.part04.sub1;

public class TestMain {
    public static class A{
        public void method1() {
            System.out.println("method1() 함수 정의");
        }
    }

    public interface B {
        public void method1();
    }

    public static void main(String[] args) {
        A a = new TestMain.A();
        B b = new B() {
            @Override
            public void method1() {
                System.out.println("method1() 함수 재정의");
            }
        };
        b.method1();
    }
}
