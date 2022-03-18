package ch11.part02.main2;

public class TestMain {
    public static void main(String[] args) {
        // name 전역변수 정의
        String name = "지역변수 name";
        // ITest 익명클래스 객체생성
        ITest test = new ITest() {
            @Override
            public void method() {
                // 지역변수에서 익명클래스 내부함수로의 자료전달
                System.out.println(name); // final 키워드가 생략되어 있으므로, name의 값 변경이 불가능하다
            }
        };
        test.method();
    }

    public interface ITest {
        public void method();
    }
}
