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
                        System.out.println("list size [ " + list.size() + "]" + " 마지막 값 [" + list.get(size - 1) + "], list " + list);
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
