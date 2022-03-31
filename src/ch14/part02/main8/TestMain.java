package ch14.part02.main8;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread(1); // 우선순위 가장 낮음
        MyThread t2 = new MyThread(5); // 우선순위 기본설정
        MyThread t3 = new MyThread(10); // 우선순위 가장 높음
        t1.start();
        t2.start();
        t3.start();

        // 메인쓰레드 5초간 대기
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // 쓰레드 모두 종료
        t1.setStop(true);
        t2.setStop(true);
        t3.setStop(true);

        t1.join();
        t2.join();
        t3.join();

    }

    // MyThread 타입 정의
    public static class MyThread extends Thread {
        // available, stop 속성 정의
        boolean available = true;
        boolean stop = false;

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        // 객체별로 우선순위를 설정할 수 있도록 생성자함수 정의
        public MyThread(int priority) {
            System.out.println(Thread.currentThread().getName() + " 의 우선순위는 [" + priority + "]");
            if (priority > 0 && priority <= 10) {
                this.setPriority(priority);
            }
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            int count = 0;

            // stop이 true일 경우에는 쓰레드 메인로직 종료
            while (!stop) {
                // available이 false의 경우 Thread.yield()를 실행
                if (available) {
                    System.out.println(name + " Thread 실행[" + (++count) + "]");
                } else {
                    System.out.println(name + " yield() 실행" + (++count) + "]");
                    Thread.yield();
                }
            }
        }
    }
}
