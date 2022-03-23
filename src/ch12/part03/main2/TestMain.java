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
    }
}