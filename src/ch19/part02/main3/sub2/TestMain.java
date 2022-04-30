package ch19.part02.main3.sub2;


import java.util.Arrays;
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
        Stream<String> filter = strings.stream().filter(s -> !s.isEmpty());
//        System.out.println(filter);

        System.out.print("filter() : ");
        filter.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 값이 2보다 큰 값만 출력 : filter()
        Stream<Integer> filter2 = numbers.stream().filter(i -> i > 2);
        System.out.print("filter() : ");
        filter2.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}
