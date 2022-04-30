package ch19.part02.main1;


import java.util.*;

// Stream 함수는
public class TestMain {
    public static void main(String[] args) {
        // 리스트생성
        List<String> list = new ArrayList<>();
        list.add("아메리카노");
        list.add("까페라떼");
        list.add("까페모카");

        // 기존의 방법으로 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("-->> collection 정렬");
        for (String obj : list) {
            System.out.println(obj);
        }

        // 스트림을 이용하여 정렬
        System.out.println("-->> stream 정렬");

        /**
         * sorted() method를 이용하여 기본 정렬한다
         * forEach() 메소드를 이용하여 자체 반복문을 돌리면서 출력한다.
         * System.out::println 은 메소드 참조 형식으로 System.out 클래스의 println() 메소드를 사용하겠다는 뜻임
         * 메소드 참조를 람다식으로 바꾸게 되면 다음과 같다
         * list.stream().sorted().forEach(item -> System.out.println(item));
         */
//        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted().forEach(item -> System.out.println(item));
    }
}