package ch14.part02.main2;

public class TestMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                print(4);
            }
        }, "thread1");

//        Thread thread = new Thread("thread1") {
//            @Override
//            public void run() {
//                print(6);
//            }
//        };

        // 1. 데몬설정
        thread.setDaemon(true); // 데몬실행을 하면 메인쓰레드가 종료되면, 데몬설정된 쓰레드들도 같이 종료된다
        thread.start();

        Thread thread2 = new Thread("thread2") {
            @Override
            public void run() {
                print(6);
            }
        };

        // 2. 데몬설정
        thread2.setDaemon(true); // 데몬실행을 하면 메인쓰레드가 종료되면, 데몬설정된 쓰레드들도 같이 종료된다
        thread2.start();

        print(2); // main 쓰레드
    }

    // 1초마다 쓰레드 정보를 count 수만큼 호출하기 위한 함수
    public static void print(int count) {
        Thread thread = Thread.currentThread();
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + "[" + (i + 1) + "]");
        }
    }
}
