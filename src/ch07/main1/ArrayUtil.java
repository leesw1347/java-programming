package ch07.main1;

import java.lang.reflect.Array;

public class ArrayUtil {
    /**
     * ProductVo 타입 외에 모든 타입에 적용할 수 있는 범용적인 배열 처리 유틸 클래스 정의
     * 배열 add() 함수, update() 함수, delete() 함수
     */

    /**
     * 배열, 자료 -> 배열 마지마에 자료추가 된 신규배열 반환
     */
    public static <T> T[] add(T[] arr, T t) {
        if (arr == null) {
            return null;
        }
        T[] newInstance = (T[]) Array.newInstance(t.getClass(), arr.length + 1);
        System.arraycopy(arr, 0, newInstance, 0, arr.length);
        newInstance[arr.length] = t;
        return (T[]) newInstance;
    }

    /**
     * 배열, 인덱스 -> 배열 인덱스 자료가 삭제된 신규배열 반환
     */
    public static <T> T[] remove(T[] arr, int removeIndex) {
        if (arr == null) {
            return null;
        }
        if (arr.length <= removeIndex || removeIndex < 0) {
            return arr;
        }
        T[] newInstance = (T[]) Array.newInstance(arr[0].getClass(), arr.length - 1);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != removeIndex) {
                newInstance[index++] = arr[i];
            }
        }
        return (T[]) newInstance;
    }

    /**
     * int 타입 배열, 자료 -> 배열 마지막에 자료추가된 신규배열 반환
     */
    public static int[] add(int[] arr, int t) {
        if (arr == null) return null;
        int[] arr2 = new int[arr.length + 1];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        arr2[arr.length] = t;
        return arr2;
    }

    /**
     * int 타입 배열, 인덱스 -> 배열 인덱스 자료가 삭제된 신규배열 반환
     */
    public static int[] remove(int[] arr, int removeIndex) {
        if (arr == null) return null;
        if (arr.length <= removeIndex || removeIndex < 0) {
            return arr;
        }

        int[] newInstance = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (removeIndex != i) {
                newInstance[index++] = arr[i];
            }
        }
        return newInstance;
    }
}
