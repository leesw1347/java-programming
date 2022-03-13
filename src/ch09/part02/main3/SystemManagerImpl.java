package ch09.part02.main3;

/**
 * 시스템 매니저 클래스 정의
 */
public class SystemManagerImpl implements ISystemManager {
    /**
     * 시스템 start() 로직 구성
     * 시스템 stop() 로직 구성
     * 시스템 status() 로직 구성
     */
    @Override
    public void start() {
        System.out.println("system start()");
    }

    @Override
    public void stop() {
        System.out.println("system stop()");
    }

    @Override
    public void status() {
        System.out.println("system status()");
    }

    // 메인 함수 정의
    public static void main(String[] args) {
        SystemManagerImpl systemManager = new SystemManagerImpl();
        systemManager.start();
        systemManager.stop();
        systemManager.status();
    }
}
