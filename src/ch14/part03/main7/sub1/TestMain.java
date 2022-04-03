package ch14.part03.main7.sub1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture 객체 생성 및 complete() 함수를 이해
 * get(), join() 함수의 차이점을 이해한다.
 * 기존 Thread 사용 로직에서 종료 후 처리 결과를 받기 위한 작업
 */
public class TestMain {
    public static void main(String[] args) {
        /**
         * future.get(), future.join()의 차이점
         * 두 함수의 결과는 동일하며, get()의 경우는 예외 처리를 해야하고,
         * join()의 경우 예외처리를 하지 않아도 된다
         */

        // 1. CompletableFuture future 객체생성
        CompletableFuture future = new CompletableFuture();

        // 2. Thread 정의 및 run() 함수 재정의 및 쓰레드 시작
        new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 3; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sum += i;
                    System.out.println("i = [" + i + "], sum=" + "[" + sum + "]");
                }

                // 3. run() 함수 종료 시 결과 값을 future에 저장
                future.complete(sum);
            }
        }.start();
        System.out.println("쓰레드 start() 완료"); // start가 먼저 출력 되므로, 비동기로 함수가 실행된다

        // 쓰레드가 실행되어 complete() 결과 값이 반환할 때까지 대기
        try {
            // 4. future.get() 또는 future.join() 함수로 결과 값을 불러오기
            // 쓰레드가 끝날때 까지 메인 쓰레드를 대기 시킨다
            Object object = future.get();
            System.out.println("Future.get() 결과 값 = " + object);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4. future.join() 함수로 결과 값을 불러오기
        // 쓰레드가 끝날때 까지 메인 쓰레드를 대기 시킨다
        Object join = future.join();
        System.out.println("결과 값 = " + join);
        System.out.println("메인함수 종료");
    }
}
