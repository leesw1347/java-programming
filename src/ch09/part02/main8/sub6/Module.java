package ch09.part02.main8.sub6;

public class Module {
    // * execute() 모듈화를 위한 함수 정의
    public static void execute(A a) {
        // 모듈처리를 위한 로직처리
        System.out.println("execute() 모듈 처리");

        // a 객체가 B 타입의 경우, 추가적인 예외 처리를 위한 로직 처리
        if (a instanceof B) {
            // B 타입으로 다운 캐스팅 -> method2() 함수 사용
            B b = (B) a;
            b.method2();
        }
    }
}
