package ch12.part03.main3.sub1;

import ch09.part02.main3.ISystemManager;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // 객체생성
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");

        System.out.println(MessageFormat.format("[list1] {0}", list1));
        System.out.println();

        // 객체복사 [Shallow Copy] list2
        List<String> list2 = list1;
        System.out.println("[list2]자료복사(Shallow Copy)");
        System.out.println(MessageFormat.format("\t[list2] {0}", list2));
        System.out.println("\t list1 == list2 : " + (list1 == list2));
    }
}
