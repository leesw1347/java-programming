package ch14.part02.main4;

public class TestMain {
    public static void main(String[] args) {
        // 쓰레드 객체생성
        Thread thread = new MyThread();

        // 쓰레드 실행
        thread.start();

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 쓰레드 인터럽트
        thread.interrupt();

    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
//            super.run();
            Thread thread = Thread.currentThread();
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 인터럽트 -> 여기서는 루프를 벗어날 수 있도록 로직을 구성한다
                    break;
                }
                // 메인로직 실행구간
                System.out.println(thread.getName() + " [" + (i + 1) + "]");
                i++;
            }
            System.out.println("로직종료");
        }
    }
}
