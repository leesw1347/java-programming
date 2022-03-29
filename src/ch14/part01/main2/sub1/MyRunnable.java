package ch14.part01.main2.sub1;

public class MyRunnable implements Runnable {

    // 전역변수 msg, interval 정의
    private String msg;
    private int interval;

    // 생성자함수 정의
    public MyRunnable(String msg, int interval) {
        this.msg = msg;
        this.interval = interval;
    }

    // run() 함수 재정의
    @Override
    public void run() {
        // 쓰레드 로직처리 구간
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
    }
}
