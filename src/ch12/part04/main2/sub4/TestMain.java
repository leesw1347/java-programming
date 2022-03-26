package ch12.part04.main2.sub4;

import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {

        // 1. 객체생성 및 자료등록
        System.out.println(" 객체생성 및 자료등록 ");
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "a");
        map1.put("2", "b");
        map1.put("3", "c");
        map1.put("4", "d");
        System.out.println("map1 = " + map1);
        System.out.println();


    }
}
