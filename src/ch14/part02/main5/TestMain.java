package ch14.part02.main5;

import javax.swing.plaf.TableHeaderUI;

public class TestMain {
    public static void main(String[] args) {
        // Thread 타입 익명클래스 객체생성
        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();

                // 인터럽트 1 : isinterrupt() -> interrupted() 조회
                t.interrupt();
                System.out.println("1-1 is Interrupted() = " + t.isInterrupted()); // true
                System.out.println("1-2 is Interrupted() = " + t.isInterrupted()); // true
                System.out.println("1-3 is Interrupted() = " + Thread.interrupted()); // true

                // 인터럽트 2 - interrupted() -> isInterrupt() 조회
                t.interrupt();
                System.out.println("2-1 interrupted() = " + Thread.interrupted()); // true
                System.out.println("2-2 interrupted() = " + Thread.interrupted()); // false
                System.out.println("2-3 isInterrupted() = " + t.isInterrupted()); // false

                // 인터럽트 3 : 예외처리구간에서 isInterrupted() 조회
                t.interrupt();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("3-1 isInterrupted() = " + t.isInterrupted()); // false
                    System.out.println("3-2 isInterrupted() = " + t.isInterrupted()); // false
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        // Thread2 객체생성
        Thread thread2 = new Thread() {
            @Override
            public void run() {
//                super.run();
                while (true) {
                    boolean interrupted = this.isInterrupted();
                    if (interrupted) { // 쓰레드가 인터럽트가 걸렸는지 확인
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            System.out.println("5. isInterrupted() : InterruptedException 구간에서 break");
                            e.printStackTrace();
                        }
                        System.out.println("5. isInterrupted() : InterruptedException 없이 break");
                        break;
                    }
                }
            }
        };

        // thread2 실행 이후 0.1초 뒤 interrupt() 함수 실행
        thread2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();

        // Thread3 객체생성
        Thread thread3 = new Thread() {
            @Override
            public void run() {
//                super.run();
                while (true) {
                    boolean interrupted = this.isInterrupted();
                    if (interrupted) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            System.out.println("6. interrupted() : InterruptedException 구간에서 break");
                            e.printStackTrace();
                        }
                        System.out.println("6. interrupted() : InterruptedException 없이 break");
                        break;
                    }
                }
            }
        };
        // thread3 실행 이후 0.1초 뒤 interrupt() 실행
        thread3.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.interrupt();
    }
}
