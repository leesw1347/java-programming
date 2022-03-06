package ch08.part02;


import java.util.Arrays;

public class B {
    /**
     * 배열 파라미터 사용
     */

    // 반환 타입의 동적 처리 사용
    public static void main(String[] args) {
        A a = new A();
        String[] array1 = a.method("A", "B", "C", "D");
        Integer[] array2 = a.method(1, 2, 3, 4);
        System.out.println("array1 " + Arrays.toString(array1));
        System.out.println("array2 " + Arrays.toString(array2));
    }

    public void print(String[] messages) {
        if (messages == null) {
            return;
        }
        for (String s : messages) {
            System.out.println(s);
        }
    }
}

