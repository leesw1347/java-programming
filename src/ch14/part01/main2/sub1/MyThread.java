package ch14.part01.main2.sub1;

// Thread 클래스 상속
public class MyThread extends Thread {

    // 전역변수 msg, interval 정의
    private String msg;
    private int interval;

    // 생성자함수 정의
    public MyThread(String msg, int interval) {
        this.msg = msg;
        this.interval = interval;
    }

    // run() 함수 재정의
    @Override
    public void run() {
        // 쓰레드 로직처리구간
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg);
        }
    }
}
