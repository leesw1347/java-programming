package ch08.part02.main5.sub2;

import java.util.ArrayList;

/**
 * String 타입의 자료를 ArrayList에 추가하기 위한 함수 정의
 */
public class ArrayListUtil {
    /**
     * String 타입의 자료를 ArrayList에 추가하기 위한 함수
     */
    public static void add(ArrayList<String> list, String... str) {
        System.out.println("\t add(ArrayList<String> list, String ... str) 함수 실행");
        if (list == null || str == null) {
            return;
        }

        for (String s : str) {
            list.add(s);
        }
    }

    /**
     * 제네릭스를 이용하여 특정타입의 자료를 ArrayList에 추가하기 위한 함수
     */
    public static <T> void add(ArrayList<T> list, T... str) {
        System.out.println("\t add<ArrayList> list, T ... str");
        if (list == null || str == null) {
            return;
        }
        for (T s : str) {
            list.add(s);
        }
    }
}
