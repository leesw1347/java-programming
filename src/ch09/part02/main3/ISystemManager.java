package ch09.part02.main3;

/**
 * 인터페이스 정의
 */
public interface ISystemManager {
    /**
     * 1. 시스템 구동 기능 정의
     * 2. 시스템 정지 기능 정의
     * 3. 시스템 상태 기능 정의
     * 추상 메소드의 정의는 abstract 키워드를 사용해야 하며, 인터페이스에서는 생략이 가능하다
     */

    // 1. 시스템 구동기능 정의
    public abstract void start();

    // 2. 시스템 정지기능 정의
    public abstract void stop();

    // 3. 시스템 상태기능 정의
    public abstract void status();
}
