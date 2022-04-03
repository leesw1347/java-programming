package ch14.part03.main7.sub2;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class TestMain {

    // start에서 end의 값까지 합산한 값을 반환하는 함수 정의
    public static int print(int start, int end, String title) {
        System.out.println(title + " 함수시작");
        int sum = 0;

        for (int i = start; i <= end; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
            System.out.println(title + " : : i = [" + i + "], sum = [" + sum + "]");
        }
        System.out.println(title + " 함수종료");
        return sum;
    }

    public static void main(String[] args) {
        // Runnable 구현 객체를 이용하여 runAsync() 함수 실행
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                print(1, 3, "runAsync()");
            }
        });

        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return print(1, 3, "supplyAsync()");
            }
        });

        // future1, future2 결과 값이 나타날 때까지 메인쓰레드를 대기시킨다
        Void join1 = future1.join();
        Integer join2 = future2.join();

        System.out.println("future1 결과 값 = " + join1);
        System.out.println("future2 결과 값 = " + join2);
    }
}
