package ch14.part02.main8;

public class TestMain {
    public static void main(String[] args) {

    }

    // MyThread 타입 정의
    public static class MyThread extends Thread {
        // available, stop 속성 정의
        boolean available = true;
        boolean stop = false;

        // 객체별로 우선순위를 설정할 수 있도록 생성자함수 정의
        public MyThread(int priority) {
            System.out.println(Thread.currentThread().getName() + " 의 우선순위는 [" + priority + "]");
            if (priority > 0 && priority <= 10) {
                this.setPriority(priority);
            }
        }
    }
}
