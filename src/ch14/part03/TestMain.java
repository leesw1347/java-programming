package ch14.part03;

import java.util.concurrent.Callable;

public class TestMain {
    public static void main(String[] args) {
    }



    // Callable 인터페이스 구현 MyCallable 클래스 정의
    public static class MyCallable implements Callable<String> {

        private String name;

        public MyCallable() {
            this.name = "";
        }

        public MyCallable(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println();
            }
            return null;
        }
    }
}
