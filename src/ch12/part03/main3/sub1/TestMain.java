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
        System.out.println(MessageFormat.format("메모리 주소 {0}\t{1}", list1, list2));
        System.out.println();

        // 객체복사 [Deep Copy] list3
        ArrayList list3 = (ArrayList) list1.clone();
        System.out.println("[list3]자료복사(DeepCopy)");
        System.out.println(MessageFormat.format("\t[list3] {0}", list3));
        System.out.println();

        // 자료추가 시 Shallow Copy 와 Deep Copy
        list1.add("e");
        System.out.println("[list1 'e'] 자료추가");
        System.out.println(MessageFormat.format("\t[list1] {0}", list1));
        System.out.println(MessageFormat.format("\t[list2] {0}", list2));
        System.out.println(MessageFormat.format("\t[list3] {0}", list3));
    }
}
