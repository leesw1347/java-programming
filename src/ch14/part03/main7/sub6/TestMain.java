package ch14.part03.main7.sub6;

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
            System.out.println(title + " : i = [" + i + "], sum = [" + sum + "]");
        }
        System.out.println(title + " 함수종료");
        return sum;
    }

    public static void main(String[] args) {
        // Supplier() 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future1
                = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return print(1, 2, "supplyAsync1()");
            }
        });

        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future2
                = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return print(3, 6, "supplyAsync2()");
            }
        });

        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future3
                = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return print(7, 11, "supplyAsync3()");
            }
        });

        // allOf() 함수의 사용, 비동기 함수 통합 실행
        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                future1, future2, future3
        );

        // allOf의 결과 값이 나타날 때까지 메인 쓰레드를 대기 시킨다
        Void join = allOf.join();
        System.out.println("allOf 결과 값 = " + join);
        System.out.println();

        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future4
                = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return print(1, 5, "supplyAsync4()");
            }
        });

        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future5
                = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return print(3, 6, "supplyAsync5()");
            }
        });

        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
        CompletableFuture<Integer> future6
                = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return print(7, 11, "supplyAsync6()");
            }
        });

        // allOf() 함수를 주석 처리 후
        // anyOf() 함수의 사용 - 비동기 함수 통합실행 및 비동기 최초 종료 시 종료
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(
                future4, future5, future6
        );

        // anyOf의 결과 값이 나타날 때까지 메인쓰레드를 대기시킨다
        Object join2 = anyOf.join();
        System.out.println("anyOf 결과 값 = " + join2);
    }
}
