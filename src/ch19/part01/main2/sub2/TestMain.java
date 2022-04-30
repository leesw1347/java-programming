package ch19.part01.main2.sub2;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        // 리스트생성
        List<String> names1 = new ArrayList<>();
        names1.add("b");
        names1.add("c");
        names1.add("a");

        // 리스트 생성
        List<String> names2 = new ArrayList<>();
        names2.add("b");
        names2.add("c");
        names2.add("a");

        // 객체 생성
        System.out.println("Sort 익명클래스");
        TestMain testMain = new TestMain();
        testMain.sort1(names1);
        System.out.println(names1);

        System.out.println("Sort 람다식");
        testMain.sort2(names2);
        System.out.println(names2);
    }

    // 익명클래스 표현식을 위한 함수 정의
    private void sort1(List<String> names)  {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    // 람다 표현식을 위한 함수 정의
    private void sort2(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
