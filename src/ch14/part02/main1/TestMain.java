package ch14.part02.main1;

/**
 * Thread 실행 시 쓰레드에 대한 정보를 조회하도록 한다
 * 학습 과정에서 Thread는 익명 클래스로 정의하도록 하겠다
 */
public class TestMain {
    public static void main(String[] args) {
        /**
         * 메인 함수 실행
         *  TableGroup 객체생성
         *  Thread1 정의 및 객체 생성
         *      쓰레드 내에서 print() 함수 실행
         *  print() 함수 정의
         */

        // ThreadGroup 객체생성
        // 쓰레드 그룹명이 'threadGroup' 이며 메인 쓰레드 그룹과 다른 그룹 객체를 사용
        // 쓰레드명은 'thread1'으로 설정하였다
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");

        // Thread1 정의 및 객체생성
        // 쓰레드명을 thread1로 지정하였다.
        Thread thread1 = new Thread(threadGroup, "thread1") {
            @Override
            public void run() {
                // 쓰레드 내에서 print() 함수 실행
                print();
                try {
                    // 1000밀리초(1초) 동안 대기하기
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // print() 함수와 thread1.start() 로직 순서를 바꿀 경우 동시작업이 진행된다
        thread1.start(); // thread1 쓰레드 시작하기, print() 함수 실행

        // 단순 Thread는 생성 시 쓰레드 그룹을 설정하지 않아 'main' 쓰레드 그룹으로 자동 설정된다
        print(); // 메인쓰레드 내에서 print() 함수 실행

    }

    public static void print() {
        Thread thread = Thread.currentThread(); // 해당 함수를 실행하는 쓰레드 객체를 반환
        ThreadGroup threadGroup = thread.getThreadGroup(); // 해당 쓰레드의 쓰레드 그룹을 반환
        String groupName = threadGroup.getName(); // 쓰레드 그룹명을 반환
        int activeCount = threadGroup.activeCount(); // 동일 쓰레드 그룹 및 하위 쓰레드 그룹에서 현재 실행되고 있는 쓰레드의 수를 반환
        int activeGroupCount = threadGroup.activeGroupCount(); // 쓰레드 그룹 및 하위 쓰레드 그룹에서 실행되고 있는 쓰레드 그룹의 수를 반환한다

        String name = thread.getName(); // 쓰레드명 반환
        int priority = thread.getPriority(); // 쓰레드 우선순위 반환
        Thread.State state = thread.getState(); // 쓰레드 상태를 반환
        int activeCount2 = Thread.activeCount(); // 동일 쓰레드 그룹 및 하위 쓰레드그룹에서 현재 실행되고 있는 쓰레드의 수를 반환

        System.out.println(
                name + "\t ThreadGroup groupName [" + groupName + "]"
        );
        System.out.println(
                name + "\t ThreadGroup activeCount [" + activeCount + "]"
        );
        System.out.println(
                name + "\t ThreadGroup activeGroupCount [" + activeGroupCount + "]"
        );

        System.out.println(name + "\t Thread name [" + name + "]");
        System.out.println(name + "\t Thread priority [" + priority + "]");
        System.out.println(name + "\t Thread state [" + state + "]");
        System.out.println(name + "\t Thread activeCount2 [" + activeCount2 + "]");
    }
}
