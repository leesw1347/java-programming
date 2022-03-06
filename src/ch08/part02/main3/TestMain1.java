package ch08.part02.main3;

public class TestMain1 {
    /**
     * static method() 함수 정의
     * 변수의 값 증가
     *
     * 메인 함수 정의
     * count 변수의 생성
     * count를 파라미터로 전달하여 함수 내부에서 값 증가
     * count의 값 비교
     * -> 값의 변경이 없다 (함수 실행 후 값의 영향이 없다)
     */

    /**
     * static method() 함수의 정의
     */
    public static int method(int count){
        // 변수의 값 증가
        return count++;
    }

    public static void main(String[] args) {
        /**
         * count 변수의 생성
         */
        int count = 0;
        System.out.println("count = " + count); // count = 1

        /**
         * count를 파라미터 전달하여 함수내부에서 값을 증가
         */
        method(count);

        /**
         * count의 값은 그대로 유지된다.
         */
        System.out.println("count = " + count); // count = 1
    }
}
