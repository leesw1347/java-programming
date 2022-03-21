package ch12.part02.main2.sub1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        // 1. ArrayList 객체생성
        List list1 = new ArrayList<>();

        // 2. LinkedList 객체 생성
        List list2 = new LinkedList();

        // 3. 제네릭스를 이용한 ArrayList 생성
        List<String> list3 = new ArrayList<String>();

        // 4. 제네릭스를 이용한 LinkedList 객체생성
        List<String> list4 = new LinkedList<String>();
    }
}
