package ch12.part03.main2.sub4;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // List 객체생성 및 자료등록
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        System.out.println(MessageFormat.format("[list1] {0}", list1));

        // 1. 자료추출
        List<String> subList1 = list1.subList(0, 3);
        System.out.println("1. 자료추출 --");
        System.out.println(MessageFormat.format("\t list.subList(0,3) = {0}", list1));
        System.out.println(MessageFormat.format("[list1] {0}", list1));
        System.out.println();

        // 2. 일괄자료 등록
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("e");
        list2.add("j");
        list2.add("k");
        list1.addAll(list2);

        System.out.println("2. 일괄자료등록 --");
        System.out.println(MessageFormat.format("\t[list2] {0}", list2));
        System.out.println(MessageFormat.format("[list1]list1.addAll(list2) = {0}", list1));

        // 3. 일괄자료포함여부
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");

        System.out.println("3. 일괄자료포함여부 --");
        System.out.println(MessageFormat.format("\t[list3] {0}", list3));
        boolean containsAll1 = list1.containsAll(list3);
        System.out.println();
    }
}
