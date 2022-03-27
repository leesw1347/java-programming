package ch12.part05.sub1;

import java.util.Properties;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {
        // 객체생성 및 자료등록 put()
        System.out.println(" Properties 객체생성 및 자료등록 ");
        Properties prop = new Properties();
        prop.put("1", "a");
        prop.put("2", "b");
        prop.put("3", "c");
        prop.put("4", "d");
        prop.put("5", "e");
        System.out.println("prop = " + prop);
        System.out.println();

        // 자료수정 : put()
        System.out.println(" Properties 자료수정 : [3,c] -> [3,f]");
        prop.put("3", "f");

        System.out.println("prop = " + prop);
        System.out.println();

        // 자료삭제 : remove()
        System.out.println(" Properties 자료삭제 : 2");
        prop.remove("2");
        System.out.println("prop = " + prop);
        System.out.println();

        // 전체자료조회 : keySet(), get()
        System.out.println(" Properties 자료조회 ");
        Set<Object> keySet = prop.keySet();
        for (Object o : keySet) {
            System.out.println("\t" + o + " : " + prop.get(o));
        }
        System.out.println("prop = " + prop);
        System.out.println();

        // String 자료 접근 : getProperty()
        System.out.println(" Properties String 타입 자료조회 : [key=1]");
        String property1 = prop.getProperty("1");
        System.out.println("prop property [key=1] = " + property1);
        System.out.println("prop = " + prop);
    }
}
