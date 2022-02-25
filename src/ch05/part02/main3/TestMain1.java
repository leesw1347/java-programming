package ch05.part02.main3;

public class TestMain1 {

    public static void main(String[] args) {
        /**
         * String 배열 객체 생성
         */
        String[] arr = new String[]{"a", "b", "c"};

        /**
         * for문을 이용하여 접근 - 배열의 인덱스 이용
         */
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
        System.out.println();

        /**
         * 향상된 for 문을 이용하여 자료 접근
         */
        for (String s : arr) {
            System.out.println("자료조회 = " + s);
        }
    }
}