package ch19.part02.main3.sub2;


import org.jetbrains.annotations.VisibleForTesting;

import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// 중간 연산 이후 최종 연산 함수를 사용하여 나타내었으며, 최종 연산은 바로 다음에 학습할 것이다
public class TestMain {
    public static void main(String[] args) {
        // 문자 리스트 생성
        List<String> strings = Arrays.asList("a", "j", "k", "j");

        // 숫자 리스트 생성
        List<Integer> numbers = Arrays.asList(3, 7, 6, 8, 2, 4, 1);

        // 값이 없는 요소 제외: filter()
        // filter: java.util.stream.ReferencePipeline
        // filter는 스트림에서 원하는 조건으로 검색해준다
        // 조건식에는 람다식을 전달할 수 있다
        Stream<String> filter = strings.stream().filter(s -> !s.isEmpty());
//        System.out.println(filter);

        System.out.print("filter() : ");
        filter.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 값이 2보다 큰 값만 출력 : filter()
        // 2를 초과하는 요소를 검색한다
        Stream<Integer> filter2 = numbers.stream().filter(i -> i > 2);
        System.out.print("filter() : ");
        filter2.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 값이 없는 요소 제외하고, 중복값 제거: distinct();
        Stream<String> distinct = strings.stream().distinct().filter(s -> !s.isEmpty());
        System.out.println("distinct() : ");
        distinct.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 기본정렬: sorted()
        Stream<Integer> sorted = numbers.stream().sorted();
        System.out.print("sorted() : ");
        sorted.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // Comparator 익명함수 람다식으로 정렬 : sorted()
        // disticnt()로 중복을 제거하고, 비교자로 전달된 람다식 'sorted((s1, s2) -> s1.compareTo(s2))'에 의해 기본 정렬된다
        Stream<String> sorted2 = strings.stream().distinct().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o1 + " " + o2 + "::" + o1.compareTo(o2));
                return o1.compareTo(o2);
            }
        });
        sorted2.forEach(item -> System.out.print(item + " "));

        // 스트림에서 요소 2개만 반환 : limit()
        Stream<String> limit = strings.stream().limit(3);
        System.out.print("limit() : ");
        limit.forEach(item -> System.out.print(item + " "));

        // 스트림에서 앞에서 2개 제외하고 반환 : skip()
        Stream<String> skipStream = strings.stream().skip(2);
        skipStream.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 두 개의 스트림을 하나의 스트림으로 결합 : concat()
        Stream<String> stream1 =
                strings.stream().distinct().filter(item -> !item.isEmpty()); // strings에서 값이 비어지있지 않은 경우만 추출
        Stream<String> stream2 = Arrays.asList("m", "j").stream();
        Stream<String> concat = Stream.concat(stream1, stream2);
        System.out.print("concat() : ");
        concat.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 길이가 4자 이상, 중복 제거한 배열에 aaa를 합친 문자열 반환: map()
        // disticnt()로 스트림 요소를 중복 제거한다
        // filter(s->s.length() > 0)는 길이가 0보다 큰 요소를 검색한다
        // map(s->s.concat("##")) 로 요소마다 "##" 문자를 결합하여 새로운 요소의 스트림을 반환한다
        Stream<String> map2
                = strings.stream().distinct().filter(s -> s.length() > 0).map(s -> s.concat("##"));
        System.out.print("map() : ");
        map2.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 2차원 배열을 단일 스트림으로 반환 : flatMap()
        String[][] str2 = new String[][]{
                {"a", "b"}, {"c", "d"}, {"e", "b"}
        };

        Stream<String> flatMap = Stream.of(str2).flatMap(array -> Arrays.stream(array));
        System.out.print("floatMap() : ");
        flatMap.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}
