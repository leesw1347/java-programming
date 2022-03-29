package ch14.part01.main2.sub1;

public class TestMain {
    public static void main(String[] args) {

        // 메인함수 시작
        System.out.println("메인함수 실행");

        // 쓰레드 객체생성
        Thread thread1 = new MyThread("thread1", 1000);
        Thread thread2 = new MyThread("thread2", 700);

        // Runnable 타입 객체를 이용한 Thread 객체 생성
        Thread thread3 = new Thread(new MyRunnable("thread3", 300));

        // thread1, thread2, thread3 쓰레드 실행
        thread1.start(); // 쓰레드생성 -> 다음 명령 행으로 이동
        thread2.start(); // 쓰레드생성 -> 다음 명령 행으로 이동
        thread3.start(); // 쓰레드생성 -> 다음 명령 행으로 이동

        // 메인함수 종료
        System.out.println("메인함수 종료");
    }
}
