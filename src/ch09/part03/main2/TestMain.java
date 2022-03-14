package ch09.part03.main2;

public class TestMain {
    // 메인함수 정의
    // ChildClass 객체 생성 및 함수 사용
    public static void main(String[] args) {
        // ChildClass 객체생성 및 함수사용
        System.out.println("ClassChild 클래스 객체생성");
        ChildClass c = new ChildClass();
        System.out.println("객체 함수사용");
        c.method2();
    }
}
