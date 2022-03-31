package ch14.part02.main7;

public class TestMain {
    public static void main(String[] args) {
        // MyThread 타입 객체 8개 생성
        // 쓰레드 6개 모두 시작
        // 첫 번째 쓰레드 available을 false로 지정
        // 5초후 모두 종료
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();
        MyThread t6 = new MyThread();

        // 쓰레드 모두 시작
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        // t1 쓰레드 available 속성 false 지정
        // 다른 쓰레드에게 실행을 넘겨주어, 결과값이 적게 나타난다
        // 필요할 때에만 주로 일을 처리한다면 쓰레드의 업무 배분을 좀 더 효율적으로
        // 할 수 있다
        t1.setAvailable(false);

        // 메인 쓰레드 5초간 대기
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 쓰레드 모두 종료
        t1.setStop(true);
        t2.setStop(true);
        t3.setStop(true);
        t4.setStop(true);
        t5.setStop(true);
        t6.setStop(true);

    }

    public static class MyThread extends Thread {
        private boolean available = true;
        private boolean stop = false;

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public void setStop(boolean stop) {
            this.stop = stop;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            int count = 0;

            // stop 이 true일 경우에는 쓰레드 메인로직 종료
            while (!stop) {

                // available이 false일 경우에는 Thread.yield 실행
                if (available) {
                    System.out.println(name + " Thread 실행[" + (++count) + "]");
                } else {
                    System.out.println(name + " yield() 실행[" + (++count) + "]");
                    Thread.yield();
                }
            }
        }
    }
}
