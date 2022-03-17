package ch10.part01.main7;

// 사용자 예외 처리를 위한 클래스

// Throwable 클래스는 예외 처리 클래스의 최상위 클래스임
// Throwable 클래스 외 모든 예외 타입의 클래스를 상속 받을 수 있다
public class MyException extends Throwable {
    // 생성자함수 정의
    public MyException(String msg) {
        // 부모의 생성자함수를 사용
        super(msg);
    }
}
