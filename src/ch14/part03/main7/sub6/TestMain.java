package ch14.part03.main7.sub6;

public class TestMain {

    // start에서 end의 값까지 합산한 값을 반환하는 함수 정의
    public static int print(int start, int end, String title) {
        System.out.println(title + " 함수시작");
        int sum = 0;
        for (int i = start; i <= end; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
            System.out.println(title + " : i = [" + i + "], sum = [" + sum + "]");
        }
        System.out.println(title + " 함수종료");
        return sum;
    }

    public static void main(String[] args) {
    }
}
