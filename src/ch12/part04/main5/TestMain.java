package ch12.part04.main5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {

        // 객체생성
        System.out.println(" 객체생성 및 자료등록 ");
        Map<String, String> map1 = new HashMap<>();
        map1.put("1", "a");
        map1.put("2", "b");
        map1.put(null, "e");
        map1.put("3", null);
        System.out.println(map1);
        System.out.println();

        // Key 조회
        System.out.println(" Key 조회");
        Set<String> keySet = map1.keySet();
        System.out.println("keySet = " + keySet);

        // Key 값이 존재함
        boolean containsKey1 = map1.containsKey("3");
        boolean containsKey2 = map1.containsKey(null);
        // Key 값이 존재 안함
        boolean containsKey3 = map1.containsKey("4");

        System.out.println("containsKey1 '3' 조회 = " + containsKey1);
        System.out.println("containsKey2 null 조회 = " + containsKey2);
        System.out.println("containsKey3 '4' 조회= " + containsKey3);
        System.out.println();

        // Value 조회
        System.out.println(" Value 조회 ");
        Collection<String> values = map1.values();
        System.out.println("values = " + values);

        // value 값 존재함
        boolean containsValue1 = map1.containsValue("a");
        boolean containsValue2 = map1.containsValue(null);
        // value 값 존재 안 함
        boolean containsValue3 = map1.containsValue("f");

        System.out.println("containsValue1 'a' 조회 = " + containsValue1);
        System.out.println("containsValue2 null 조회 = " + containsValue2);
        System.out.println("containsValue3 'f' 조회' " + containsValue3);
    }
}
