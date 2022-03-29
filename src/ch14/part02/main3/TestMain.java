package ch14.part02.main3;

/**
 * join() 함수의 경우 쓰레드 실행 상태에 있을 때, 종료될 때까지 부모 쓰레드를 대기 시킨다
 */
public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        // 쓰레드 객체생성
        Thread thread1 = new MyThread("thread1", 3);
        Thread thread2 = new MyThread("thread2", 3);
        Thread thread3 = new MyThread("thread3", 3);
        Thread thread4 = new MyThread("thread4", 3);

        // thread1, thread2 쓰레드 시작
        thread1.start();
        thread2.start();

        // thread1, thread2가 종료될때까지 대기 - 다음으로 넘어가지 않음
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // thread3 쓰레드 시작
        thread3.start(); // 약 3초

        // thread3이 종료될 때까지 대기 - 다음으로 넘어가지 않음
        try {
            thread3.join();
            System.out.println("thread3 join()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // thread4 쓰레드 시작
        thread4.start();
        thread4.join();
    }

    public static class MyThread extends Thread {
        MyThread(String runName, int count) {
            this.runName = runName;
            this.count = count;
            this.setName(this.runName);
        }

        // run() 함수 재정의 (Override)
        @Override
        public void run() {
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

        private String runName;
        private int count;
    }
}