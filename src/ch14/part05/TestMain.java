package ch14.part05;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestMain {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        System.out.println(pool);

        pool.execute(new MyRunnable("thread1", 2));
        pool.execute(new MyRunnable("thread2", 4));
        pool.execute(new MyRunnable("thread3", 6));

        // 1. shutdown 함수 사용 - 주색헤재해서 사용하세요
//        pool.shutdown(); // 현재 진행되거나 대기 중인 작업은 실행되지만, 새로운 작업은 실행하지 않는다

        // 2. shutdownNow() 함수 사용
//        pool.shutdownNow(); // 현재 진행 중인 작업에서 InterruptedException을 발생 시키며, 작업은 진행된다 대기 중이거나
        // 새로운 작업은 실행하지 않는다

        // 3. awaitTermination() 함수의 사용
        try {
            boolean awaitTermination =
                    pool.awaitTermination(3500, TimeUnit.MILLISECONDS);
            System.out.println(MessageFormat.format("awaitTermination {0}", awaitTermination));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("쓰레드 종료");
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
