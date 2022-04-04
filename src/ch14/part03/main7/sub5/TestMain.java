package ch14.part03.main7.sub5;

import javax.sql.rowset.Joinable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 비동기 후처리
 * thenAccept(),
 * thenApply(),
 * execeptionally()
 */
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

//    public static void main(String[] args) {
//        // Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
//        CompletableFuture<Integer> future1
//                = CompletableFuture.supplyAsync(new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return print(1, 3, "supplyAsync1()");
//            }
//        });
//
//        // thenApply() 함수 이용하기 - 비동기함수 실행 이후 후처리 작업
//        CompletableFuture<String> future2
//                = future1.thenApply(new Function<Integer, String>() {
//            @Override
//            public String apply(Integer t) {
//                // 고의 에러발생
//                System.out.println(3 / 0);
//                return "결과 = " + String.valueOf(t);
//            }
//        });
//
//        // exceptionally() 함수 이용하기 - 비동기함수 실행 시 에러발생 시 후처리작업
//        // 오류 발생 시, 해당 함수를 콜백하며, 해당 함수가 실행된 결과 값이 join() 함수로 전달된다
//        CompletableFuture<String> future3
//                = future2.exceptionally(new Function<Throwable, String>() {
//            @Override
//            public String apply(Throwable throwable) {
//                // 에러발생 시 처리하기 위한 로직
//                System.out.println("에러발생 : " + throwable.getMessage());
//                return throwable.getMessage();
//            }
//        });
//
//        // future3의 결과 값이 나타날 때까지 메인쓰레드르 대기시킨다
//        String join = future3.join();
//        System.out.println("future3 결과 값 = " + join);
//    }

    public static void main(String[] args) {
        /**
         * Supplier 구현 객체를 이용하여 supplyAsync() 함수 실행
         */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return print(1, 3, "supplyAsync1()");
        }).thenApply(t -> {
            // 고의 에러발생
            System.out.println(3 / 0);
            return "결과 = " + String.valueOf(t);
        }).exceptionally(t -> {
            // 에러발생 시 처리하기 위한 로직
            System.out.println("에러발생 : " + t.getMessage());
            return t.getMessage();
        });

        // future의 결과 값이 나타날 때까지 메인쓰레드를 대기시킨다
        String join = future.join();
        System.out.println("future 결과 값 = " + join);
    }
}
