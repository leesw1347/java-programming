package ch12.part04.main2.sub2;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        // 객체생성
        Map<String, Integer> map1 = new HashMap<>();
        System.out.println(" 자료생성 ");
        System.out.println("map = " + map1);
        System.out.println();

        // 자료 등록 [a,b,c]
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4); // 자료의 수정 key 'a'에 값을 덮어쓴다
        System.out.println(" 자료등록 ");
        System.out.println("map1 " + map1);
        System.out.println();

        // 자료조회
        System.out.println("자료조회");
        // keySet()을 이용한 key 자료조회
        for (String key : map1.keySet()) {
            // get() 함수를 이용한 자료 조회
//            System.out.println(key);
            int data = map1.get(key);
            System.out.println("\tkey[" + key + "]," + data + "]");
        }
    }
}