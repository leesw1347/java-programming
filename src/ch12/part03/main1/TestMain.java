package ch12.part03.main1;

import java.text.MessageFormat;
import java.util.*;

public class TestMain {
    public static void main(String[] args) {

        String[] data = {"1", "a", "e", "2", "b", "b", "e", "c", "d"};

        // List 성능 검사
        {
            List<String> list = new ArrayList<>();
            long time01 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                for (String s : data) {
                    if (!(list.contains(s))) {
                        list.add(s);
                    }
                }
            }
            long time02 = System.currentTimeMillis();
            System.out.println(MessageFormat.format("[ArrayList] 걸린시간 = {0}", time02 - time01));
            System.out.println(MessageFormat.format("\t자료 {0}", list));
        }

        /**
         * HashSet 성능검사
         */
        {
            Set<String> set01 = new HashSet<>();
            long time01 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                for (String s : data) {
                    set01.add(s);
                }
            }
            long time02 = System.currentTimeMillis();
            System.out.println(MessageFormat.format("[HashSet] 걸린시간 = {0}", time02 - time01));
            System.out.println(MessageFormat.format("\t자료 {0}", set01));
        }

        /**
         * TreeSet 성능검사
         */
        Set<String> set01 = new TreeSet<>();
        long time01 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            for (String s : data) {
                set01.add(s);
            }
        }
        long time02 = System.currentTimeMillis();
        System.out.println(MessageFormat.format("[TreeSet] 걸린시간 = {0}", time02 - time01));
        System.out.println(new StringBuilder().append("\t자료 ").append(set01).toString());

        /**
         * LinkedHashSet 성능검사
         */
        {
            Set<String> set02 = new LinkedHashSet<>();
            long set02_time01 = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                for (String s : data) {
                    set01.add(s);
                }
            }
            long set01_time02 = System.currentTimeMillis();
            System.out.println(MessageFormat.format("[LinkedHashSet] 걸린시간 = {0}", time02 - time01));
            System.out.println("\t자료 " + set01);
        }
    }
}
