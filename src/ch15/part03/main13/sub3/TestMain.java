package ch15.part03.main13.sub3;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Calendar;

public class TestMain {
    public static void main(String[] args) throws IOException {
        // 1) 읽기객체, 쓰기객체 생성 및 객체연결
        PipedWriter pw = new PipedWriter();
        PipedReader pr = new PipedReader(pw);

        // 2) 송신 쓰레드정의 및 쓰기객체 호출 및 자료 쓰기작업
        Thread thread1 = new Thread() {
            @Override
            public void run() {

                // 1초마다 시간정보 전송
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 자료 쓰기작업
                    String time = Calendar.getInstance().getTime().toString();
                    try {
                        pw.write(time);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();

        // 3) 수신 쓰레드정의 및 읽기객체 호출 및 자료 읽기작업
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                char[] ch = new char[1024];
                // 1초마다 읽기작업
                while (true) {
                    try {
                        Thread.sleep(1000);
                        int read = pr.read(ch);
                        if (read != -1) {
                            System.out.println(new String(ch, 0, read));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread2.start();
    }
}
