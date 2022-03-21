package ch12.part02.main4.sub2;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        // 숫자 자료구조 생성
        System.out.println("[list1] 정렬");
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(3);
        list1.add(4);
        list1.add(1);
        list1.add(2);

        // 자료정렬
        System.out.println(MessageFormat.format("\t정렬 전\t{0}", list1));
        Collections.sort(list1);
        System.out.println(MessageFormat.format("\t정렬 후\t{0}", list1));


        // 문자열 자료구조 생성
        System.out.println("[list2] 정렬");
        List<String> list2 = new ArrayList<>();
        list2.add("나");
        list2.add("가");
        list2.add("a");
        list2.add("k");
        list2.add("D");
        list2.add("P");
        list2.add("1");
        list2.add("3");

        // 자료정렬
        System.out.println(MessageFormat.format("\t정렬 전\t{0}", list2));
        Collections.sort(list2);
        System.out.println(MessageFormat.format("\t정렬 후\t{0}", list2));
    }
}