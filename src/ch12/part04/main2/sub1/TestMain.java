package ch12.part04.main2.sub1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMain {
    public static void main(String[] args) {

        /**
         * 1. 객체생성
         */
        Map map1 = new HashMap();
        Map map2 = new TreeMap();
        Map map3 = new LinkedHashMap();

        /**
         * 4. 제네릭스를 이용한 객체생성
         * List, Set과 마찬가지로 제네릭스는 '기본형' 타입은 불가능하며,
         * Wrapper 클래스를 사용해야 한다
         */
        Map<String, Integer> map4 = new HashMap<>();
        Map<String, Integer> map5 = new TreeMap<>();
        Map<String, Integer> map6 = new LinkedHashMap<>();

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);
        System.out.println(map4);
        System.out.println(map5);
        System.out.println(map6);
    }
}
