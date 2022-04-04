package ch14.part03.main7.sub4;

import java.nio.file.attribute.GroupPrincipal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
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
            System.out.println(title + " : i = [" + i + "], sum = [" + sum + "]");
        }
        System.out.println(title + " 함수종료");
        return sum;
    }

    // 메인함수 정의
    public static void main(String[] args) {

        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(new Supplier<Integer>() {
                    @Override
                    public Integer get() {
                        return print(1, 3, "supplyAsync1()");
                    }
                });

        // thenCompose() 함수를 이용하여 비동기 작업 이후 비동기 작업 실행
        // 비동기 작업 이후 결과값을 바탕으로 새로운 비동기 작업을 하기 위한 함수임
        // 실행 결과를 보면 최초 비동기 작업이 실행되며, 해당 작업 종료 이후에 다시 비동기 작업이 실행되는 것을 확인할 수 있다
        CompletableFuture<String> future2 =
                future1.thenCompose(new Function<Integer, CompletionStage<String>>() {
                    @Override
                    public CompletionStage<String> apply(Integer t) {
                        // 비동기 작업 결과 이후에 해당 결과를 바탕으로 또 다른 비동기 작업 실행
                        CompletableFuture<String> future3 =
                                CompletableFuture.supplyAsync(new Supplier<String>() {
                                    @Override
                                    public String get() {
                                        return "결과=" + print(t, t + 1, "supplyAsync2()");
                                    }
                                });
                        return future3;
                    }
                });

        // future2의 결과 값이 나타날 때까지 메인쓰레드를 대기시킨다
        String join = future2.join();
        System.out.println("future2 결과 값 = " + join);
    }
}
