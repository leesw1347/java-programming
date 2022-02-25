package ch06.part02.main2.sub3;

import java.text.MessageFormat;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 메인 함수 정의,
         * 2차원 배열 객체 생성
         * 인덱스를 이용하여 for문으로 접근하기
         * 향상된 for문을 이용하여 접근하기
         */

        // 2차원 배열 객체 생성하기
        String[] arr1 = {"자료1", "자료2", "자료3"};
        String[] arr2 = {"자료21", "자료22", "자료23"};
        String[][] arr = new String[][]{arr1, arr2};

        /**
         * 인덱스를 이용하여 for문으로 접근하기
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String data = arr[i][j];
                System.out.println(MessageFormat.format("arr[{0}][{1}]={2}", i, j, data));
            }
        }

        /**
         * 향상된 for문을 이용하여 접근하기
         */
        for (String[] array : arr) {
            for(String s : array){
                System.out.println("arr 자료접근 = " + s);
            }
        }
    }
}
