package ch14.part02.main9;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // 자료를 CRUD 할 List 타입 객체생성
        List<Integer> list = new ArrayList<>();

        Thread t1 = new Thread() {
            @Override
            public void run() {
//                super.run();
                // list 마지막 자료삭제
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    if (list.size() > 0) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                // list 마지막 자료조회
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    int size = list.size();
                    if (size > 0) {
                        System.out.println("list size [ " + list.size() + "] 마지막 값 [" + list.get(size - 1));
                    }
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                // list 자료 등록
//                super.run();
                while (true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    list.add(list.size());

                    /** Thread에서 에러 발생 시 모든 쓰레드를 종료시키기 위함
                     * 모든 쓰레드 interrupt() -> 예외구간에서 break로 함수종료

                     if (!t1.isAlive() || !t2.isAlive()) {
                     t1.interrupt();
                     t2.interrupt();
                     interrupt();
                     }
                     */
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }
}
