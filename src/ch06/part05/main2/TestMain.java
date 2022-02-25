package ch06.part05.main2;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("자료원본\t: " + Arrays.toString(array));

        int[] array2 = ArrayUtil.add(array, 6);
        System.out.println("자료추가 6\t: " + Arrays.toString(array2));

        int[] array3 = ArrayUtil.add(array2, 2, 7);
        System.out.println("중간삽입 7\t: " + Arrays.toString(array3));

        int[] array4 = ArrayUtil.remove(array2, 1);
        System.out.println("자료삭제 2\t: " + Arrays.toString(array4));
    }
}
