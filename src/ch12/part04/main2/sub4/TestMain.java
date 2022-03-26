package ch12.part04.main2.sub4;

import java.nio.file.FileSystemNotFoundException;
import java.util.*;

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

        // 2. 일괄자료등록
        // putAll(Map<? extends Key, ? extends V> map)
        // 중복되는 key 값이 있다면, 마지막에 등록된 값으로 변경된다
        System.out.println(" 자료일괄등록 - map1.putAll(map2)");
        Map<String, String> map2 = new HashMap<>();
        map2.put("1", "e");
        map2.put("2", "f");
        map2.put("5", "g");
        map2.put("6", "h");
        map1.putAll(map2);
        System.out.println("map2 = " + map2);
        System.out.println("map1 = " + map1);
        System.out.println();

        // 3. 전체 Key 자료조회
        System.out.println(" 전체 Key 자료조회 map1.keySet()");
        Set<String> keySet = map1.keySet();
        for (String s : keySet) {
            System.out.println("\tKey 검색 = [" + s + "]");
        }
        System.out.println("map1 = " + map1);
        System.out.println();

        // 4. 전체 Value 자료 조회
        System.out.println(" 전체 Value 자료조회 map.values()");
        Collection<String> values = map1.values();
        for (String s : values) {
            System.out.println("\tValue 검색[" + s + "]");
        }
        System.out.println("map1 = " + map1);
    }
}