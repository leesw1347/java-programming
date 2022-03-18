package ch11.part02.main4;

import java.text.MessageFormat;

public class TestMain {

    private String name = null;
    Object obj = null;

    public TestMain() {
        System.out.println("TestMain 기본 생성자 함수 실행");
    }

    public TestMain(Object obj) {
        this.obj = obj;
        System.out.println(MessageFormat.format("{0} 할당", obj));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void print() {
        if (this.obj != null) {
            System.out.println(MessageFormat.format("obj {0}", ((TestMain) this.obj).getName()));
        } else {
            System.out.println(MessageFormat.format("정상적으로 정적 전역변수를 이용한 자료 연결 {0}", this.getName()));
        }
    }

    public static void main(String[] args) {
        // 문제1. 객체 'b'에 전역변수 name에 'a.name.value' 라는 값 저장
        TestMain testMain = new TestMain();
        testMain.setName("a.name.value");
        System.out.println(testMain);

        TestMain b = new TestMain(testMain);
        testMain.print();
        b.print();

        // 문제2. 객체 'a'에 객체 'b'를 '자료 전달'
        // 함수의 파라미터를 이용하여 setter 함수 정의 후 자료연결을 하시오

        // 문제3. 전달받은 B 타입 객체의 name 속성값 '자료 접근' 후 콘솔 화면 출력
        // 외부에서 접근이 가능하도록 getter 함수를 정의하여 코드를 작성

    }
}
