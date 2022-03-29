package ch14.part01.main2.sub2;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("메인함수 실행");

        // 익명클래스를 이용한 Thread 상속클래스 정의 및 객체생성
        Thread thread1 = new Thread() {
            @Override
            public void run() {
//                super.run();
                print("thread1", 1000);
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
//                super.run();
                print("thread2", 700);
            }
        };

        // 익명클래스를 이용한 Runnable 타입 클래스 정의 및 객체생성
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                print("thread3", 300);
            }
        });

        // 쓰레드 실행
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("메인함수 종료");
    }

    // thread1, thread2, thread3 내부의 run() 함수 내 공통로직을 함수로 분리
    public static void print(String msg, int interval) {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg);
        }
    }
}
