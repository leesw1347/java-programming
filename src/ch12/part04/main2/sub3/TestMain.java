package ch12.part04.main2.sub3;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        //1. 객체생성
        System.out.println(" 객체생성 ");
        Map<String, String> map = new HashMap<>();
        System.out.println("map = " + map);
        System.out.println();

        // 2. 자료등록
        System.out.println(" 자료등록 put() ");
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        System.out.println("map = " + map);
        System.out.println();

        // 3. 자료수정
        System.out.println(" 자료수정 put() ");
        map.put("1", "a1");
        map.put("3", "c1");

        System.out.println("map = " + map);
        System.out.println();

        // 4. 자료삭제
        System.out.println(" 자료삭제 remove()");
        map.remove("1");
        System.out.println("map = " + map);
        System.out.println();

        // 5. 자료포함여부
        System.out.println(" 자료포함여부 contains() ");
        boolean containsKey = map.containsKey("2");
        System.out.println("\tkey 2 존재여부 확인 = " + containsKey);
        boolean containsValue = map.containsValue("c");
        System.out.println("\tvalue c 존재여부 확인 = " + containsValue);
    }
}