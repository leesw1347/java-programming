package ch11.part02.main3;

// 조건을 유지하면서 클래스 TestMain에 나타나는 오류를 수정하시오
public class TestMain {
    // setName()으로 들어오는 파라미터 name의 값을 print() 함수 실행 시
    // 콘솔 화면에 변수 name의 값이 출력된다.
    // 전역변수 name을 정의하여 함수와 함수 사이의 자료를 연결한다
    private String name; //  = "TestMain 전역변수 정의";

    public void setName(String name) {
        /**
         * 외부에서 들어오는 파라미터를 전역변수로 전달한다
         * setName() 함수 내부 : 지역변수 name, 전역변수 name에 자료 전달
         */
        this.name = name;
    }

    /**
     * 전역변수 name 자료 접근
     */
    public void print() {
        // setName() 으로 들어오는 name 값을 출력하시오
        System.out.println(name);
    }

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.setName("아메리카노");
        testMain.print(); // 아메리카노가 출력된다
    }
}