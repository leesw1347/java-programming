package ch12.part04.main3.sub1;

import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        // 객체생성
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("1", "a");
        map1.put("2", "b");
        map1.put("3", "c");
        map1.put("4", "d");
        System.out.println(" 객체생성 및 자료등록 ");
        System.out.println("map1 = " + map1);
        System.out.println();

        // 객체복사 [Shallow Copy] list2
        Map<String, String> map2 = map1;
        System.out.println(" 자료복사(Shallow Copy)");
        System.out.println("map2 = " + map2);
        System.out.println();

        // 객체복사 [Deep Copy] list3
        Map<String, String> map3 = (Map<String, String>) map1.clone();
        System.out.println(" 자료복사(Deep Copy)");
        System.out.println("map3 = " + map3);
        System.out.println();

        // 자료추가 시 Shallow Copy와 Deep Copy
        map1.put("5", "e");
        System.out.println(" map1 자료추가 [key=5, value=e]");
        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);
        System.out.println("map3 = " + map3);
    }
}
