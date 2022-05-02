package ch19.part02.main4.sub2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        // 문자 데이터 리스트 생성
        List<String> stringList = Arrays.asList("aaa", "bbb", "CCC", "bbb");

        // 숫자 데이터 리스트 생성
        List<Integer> numbers = Arrays.asList(3, 7, 6, 8, 2, 4, 1);

        // 스트림 개수 : count()
        long count = numbers.stream().count();
        System.out.println("count() : " + count);

        // 최대값 ; max()
//        return (x < y) ? -1 : ((x == y) ? 0 : 1);
        Optional<Integer> max = numbers.stream().max(Integer::compare);

        // Optional.get은 값이 있으면 값을 던지고, 아니면 NoSuch
        System.out.println("max() : " + max.get());

        // 최소값 ; min()

        // method1
        /**
         Optional<Integer> min = numbers.stream().min(new Comparator<Integer>() {
        @Override public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? 1 : 0; // o1이 o2보다 작을 경우 true를 리턴하면, 최소 값을 구할 수 있다.
        // o1이 o2보다 클경우에는 0을 리턴하고, max 값을 구한다
        }
        });
         */

        // method2
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println("min... " + min);

        // 1번째 값 findFirst()
        // 문자열에 b가 들어간 1번째 값을 찾아낸다
        Optional<String> findFirst
                = stringList.stream().filter(s -> s.contains("b")).findFirst();
        System.out.println("findFirst() : " + findFirst.get());

        // 빈 값이 아닌 요소 중 순서에 상관 없이 일치하는 값 하나 반환 : findAny()
        Optional<String> findAny
                = stringList.stream().filter(s -> !s.isEmpty()).findAny();
        System.out.println("findAny() : " + findAny.get());

        // 'a'로 시작하는 요소가 하나라도 있는지 여부 반환(부분매치) : anyMatch()
        boolean anyMatch
                = stringList.stream().filter(s -> s.startsWith("a", 0)).anyMatch(s -> s.startsWith("a"));
        System.out.println("anyMatch() : " + anyMatch);

        // 'a'로 시작하는 요소가 있는지 여부 반환(전체매치) : allMatch()
        boolean allMatch
                = stringList.stream().allMatch(s -> s.startsWith("a"));
        System.out.println("allMatch() : " + allMatch);

        // 'D'로 시작하는 요소가 없는지 여부 반환 : noneMatch()
        boolean noneMatch
                = stringList.stream().noneMatch(s -> s.startsWith("D"));
        System.out.println("noneMatch() : " + noneMatch);

        // 스트림의 모든 요소를 배열로 반환 : toArray()

        // String 배열의 new 연산자를 generator로 넘겨준다
        String[] array = stringList.toArray(String[]::new);
        System.out.println("toArray() : " + Arrays.toString(array));

        // 스트림 숫자의 합을 구한다 : reduce()
        Integer reduce1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("reduce() : " + reduce1);

        // 스트림 요소를 Set(Collection)으로 반환 : collect()
        Set<String> collect = stringList.stream().collect(Collectors.toSet());
        System.out.println("collect() : " + collect);

        // 스트림 요소를 List(Collection)으로 반환 : collect()
        List<String> collect2
                = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println("collect() : " + collect2);

//        int x = 20;
//        int y = 10;
//        int result = (x < y) ? -1 : ((x == y) ? 0 : 1);
//        System.out.println("result " + String.valueOf(result));
    }
}
