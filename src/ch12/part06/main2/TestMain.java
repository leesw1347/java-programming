package ch12.part06.main2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {

        // List 불변 자료구조 객체생성
        List<String> of1 = List.of("자료1", "자료2", "자료3");
        System.out.println("List<String> of1 = " + of1);

        // Set 불변 자료구조 객체생성
        Set<Integer> of2 = Set.of(1, 2, 3, 4);
        System.out.println("Set<Integer> of2 = " + of2);

        // Map 불변 자료구조 객체생성
        Map<String, String> of3 = Map.of(
                "key1", "value1",
                "key2", "valu2"
        );
        System.out.println("Map<String, String> of3 = " + of3);

        // Map의 Entry를 이용한 불변 자료구조 객체생성
        Map<String, String> ofEntries = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2"),
                Map.entry("key3", "value3"),
                Map.entry("key4", "value4")
        );
        System.out.println("Map<String, String> ofEntries = " + ofEntries);
    }
}
