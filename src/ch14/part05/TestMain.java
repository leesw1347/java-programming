package ch14.part05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        System.out.println(pool);

        pool.execute(new MyRunnable("thread1", 2));
        pool.execute(new MyRunnable("thread2", 4));
        pool.execute(new MyRunnable("thread3", 6));

        // 1. shutdown 함수 사용 - 주색헤재해서 사용하세요
        pool.shutdown();

    }

    // Runnable 인터페이슥 구현 MyRunnable 클래스 정의
    public static class MyRunnable implements Runnable {
        private String title;
        private int count;

        public MyRunnable(String title, int count) {
            this.title = title;
            this.count = count;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName() + "\t" + title;
            for (int i = 0; i < count; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "\t" + i);
            }
        }
    }
}
