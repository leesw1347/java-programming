package ch14.part03.main6;

import java.security.spec.NamedParameterSpec;
import java.util.concurrent.*;

public class TestMain {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1);

        // 작업 생성 - submit() 함수, Callable 파라미터 이용
        Future<String> future1 = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return print("쓰레드1", 3);
            }
        });

        // 작업 생성 - submit() 함수, Runnable 파라미터 이용
        Future future2 = pool.submit(new Runnable() {
            @Override
            public void run() {
                print("쓰레드2", 3);
            }
        });

        // 작업 생성 - submit() 함수 - Runnable 파라미터 이용
        final Future future3 = pool.submit(new Runnable() {
            @Override
            public void run() {
                print("쓰레드3", 3);
            }
        });

        // Future get() 함수 이용 - 종료될때까지 기다린다
        try {
            String result = future1.get();
            System.out.println("결과 값 = " + result);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        // Future cancel() 함수이용 - 대기 중인 작업을 종료시킨다.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean cancel = future3.cancel(true);
//        System.out.println(cancel);

        // Future get() 함수이용 - 종료될 때까지 대기한다
        try {
            Object result2 = future2.get();
            System.out.println("결과 값 = " + result2);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("메인 쓰레드 종료");
    }

    public static String print(String title, int count) {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("\t" + title + ". 예외발생[ " + name + "]");
            }
            System.out.println(title + "." + name + "[" + i + "]");
        }
        return "쓰레드 종료 " + title + "." + name;
    }
}
