package ch12.part03.main2;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // List 객체생성 및 자료등록
        List<String> list = new ArrayList<>();
        System.out.println(MessageFormat.format("[객체생성1] {0}", list));

        // 자료등록 [a,b,c]
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(MessageFormat.format("[자료등록2] {0}", list));

        // 중간 자료등록 [d,a,b,c]
        list.add(0, "d");
        System.out.println(MessageFormat.format("[자료등록3] {0}", list));

        // 자료조회[1]
        System.out.println("[자료조회4]");
        for (int i = 0; i < list.size(); i++) {
            String data = list.get(i);
            System.out.println("\t인덱스[" + i + "] = " + data);
        }

        // 자료조회[2] 향상된 for문
        System.out.println("[자료조회5]");
        for (String data : list) {
            System.out.println(MessageFormat.format("\t자료 = {0}", data));
        }
    }
}