package ch09.part02.main8.sub4;

public class TestMain {
    // 메인함수 정의
    // B, C 타입 객체 생성
    // Module.execute 함수 사용, 여러 타입을 동일 타입으로 처리
    public static void main(String[] args) {
        // B,C 타입 객체 생성
        B b = new B();
        C c = new C();

        // Module.execute() 함수 사용, 여러 타입을 동일타입으로 처리
        Module.execute(b);
        Module.execute(c);
    }
}
