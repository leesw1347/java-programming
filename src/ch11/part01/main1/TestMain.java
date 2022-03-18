package ch11.part01.main1;

/**
 * 전역변수와 지역변수의 중복 시 자료 접근
 * 함수 내에서 전역변수와 지역변수를 구별하여 호출 할 수 있다.
 */
public class TestMain {

    // 전역변수 정의
    private String name = "전역변수 name"; // 변수1

    // method1() 함수 정의
    public void method1() {
        // 지역변수 name 정의
        String name = "지역변수 name";

        System.out.println(this.name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        // 객체생성 및 함수사용
        TestMain testMain = new TestMain();
        testMain.method1();
    }
}
