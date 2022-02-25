package ch06.part05;

import java.text.MessageFormat;
import java.util.Arrays;

public class TestMain {
    /**
     * 메인함수 정의
     * 마지막 자료 추가
     * 자료 중간 삽입
     * 인덱스 1의 자료 삭제
     * 배열 오름차순 정렬
     */

    public static void main(String[] args) {
        /**
         * 마지막 자료 추가
         */
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            array2[i] = array[i]; // 값을 추가 후 array의 인덱스의 값을 증가 시킨다
        }
        array2[array2.length - 1] = 6;

        System.out.println(MessageFormat.format("원본 {0}", Arrays.toString(array)));
        System.out.println(MessageFormat.format("array는 {0}", Arrays.toString(array2)));

        /**
         * 자료 중간삽입
         */
        int[] array3 = new int[array2.length + 1];
        int index = 2; // 입력할 인덱스의 위치
        int value = 7; // 입력할 인덱스에 입력할 자료
        int row = 0; // 복사할 array의 인덱스

        for (int i = 0; i < array3.length; i++) {
            if (index == i) {
                array3[i] = value;
            } else {
                array3[i] = array2[row]; // array의 인덱스 row를 증가시키면서 복사
                row++;
            }
        }
        System.out.println(MessageFormat.format("array3 {0}", Arrays.toString(array3)));

        /**
         * 인덱스 1의 자료삭제
         */
        int[] array4 = new int[array3.length - 1];
        int index2 = 1;
        int row2 = 0; // 복사할 array의 인덱스
        for (int i = 0; i < array3.length; i++) {
            if (index2 != i) {
                array4[row2] = array3[i];
                row2++;
            }
        }
        System.out.println("자료삭제 2\t" + Arrays.toString(array4));

        /**
         * 배열 오름차순 정렬
         */
        Arrays.sort(array4);
        System.out.println("자료정렬 \t: " + Arrays.toString(array4));
    }
}