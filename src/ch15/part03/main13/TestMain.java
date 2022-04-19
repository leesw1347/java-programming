package ch15.part03.main13;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Calendar;
import java.util.spi.CalendarDataProvider;

public class TestMain {
    public static void main(String[] args) throws IOException {
        // 1) 읽기객체, 쓰기객체 생성 및 객체연결
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream(pis);

        // 2) 송신 쓰레드 정의 및 쓰기객체 호출 및 자료 쓰기작업
        Thread thread1 = new Thread() {
            @Override
            public void run() {

                // 1초마다 시간정보 전송
                while (true) {
                    // Calendar 인스턴스 변수 정의
                    Calendar calendar = Calendar.getInstance();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 자료 쓰기작업
                    String time = calendar.getTime().toString();
                    try {
                        System.out.println("PipedOutputStream에다가 데이터를 입력합닏k -> ");
                        pos.write(time.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();

        // 3) 수신 쓰레드 정의 및 읽기객체 호출 및 자료 읽기작업
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                byte[] by = new byte[1024];

                // 1초마다 thread1에서 수신 쓰레드로 전송하는 데이터 읽어들이기
                while (true) {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        // 자료 읽기작업
                        int read = pis.read(by);
                        System.out.println(new String(by, 0, read));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread2.start();
    }
}