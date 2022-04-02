package ch14.part02.main10;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // list 객체생성
        List<Integer> list = new ArrayList<>();

        // Thread t1 객체생성
        Thread t1 = new Thread() {
            @Override
            public void run() {
//                super.run();
                while (true) {
                    // list 객체동기화 - 해당 객체 wait()
                    synchronized (list) {
                        System.out.println("쓰레드1 wait");
                        // list를 실행하고 있는 Thread(1)를 대기상태로 전환
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("쓰레드1 실행");
                }
            }
        };

        // Thread t2 객체생성
        Thread t2 = new Thread() {
            @Override
            public void run() {
//                super.run();
                while (true) {
                    synchronized (list) {
                        System.out.println("쓰레드2 wait");
                        // list를 실행하고 있는 Thread(2)를 대기상태로 전환
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("쓰레드2 실행");
                }
            }
        };

        // Thread t3 객체생성
        Thread t3 = new Thread() {
            @Override
            public void run() {
//                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // list 객체 동기화 - 해당 객체 notify(), notifyAll()
                synchronized (list) {
                    // 1, 2의 코드로 실행
//                    list.notify(); // notify는 1개의 쓰레드에만 실행상태로 전환시키기 때문에, 의도한 쓰레드가 활성화 되지 않을 수도 있다
                    list.notifyAll();
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
