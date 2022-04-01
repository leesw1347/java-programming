package ch14.part02.main9.sub1;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // 자료를 CRUD 할 List 타입 객체 생성
        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                // list 마지막 자료삭제
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                    // list 동기화
                    synchronized (list) {
                        if (list.size() > 0) {
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread() {

            // list 마지막 자료조회
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }

                // list 동기화
                synchronized (list) {
                    int size = list.size();
                    if (size > 0) {
                        System.out.println("list size [" + list.size() + "]" + " 마지막 값 [" + list.get(size - 1) + "], list " + list + "]");
                    }
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                // list 자료등록
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }

                    // list 동기화
                    synchronized (list) {
                        list.add(list.size());
                    }

                    /* Thread에서 에러발생 시 모든 쓰레드를 종료 시키기 위함
                        모든 쓰레드 interrupt() -> 예외구간에서 break로 함수종료
                     */
                    System.out.println("t1 " + t1.isAlive());
                    System.out.println("t2 " + t2.isAlive());
                    System.out.println("t3 " + isAlive());

                    if (!t1.isAlive() || !t2.isAlive()) {
                        t1.interrupt();
                        t2.interrupt();
                        interrupt();
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}