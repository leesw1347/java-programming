package ch19.part02.main2.sub2;

import org.jetbrains.annotations.VisibleForTesting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {
        // 배열선언
        String[] array = {
                "a", "b", "c"
        };

        // 배열로 리스트 생성
        List<String> list = Arrays.asList(array);

        // 리스트로 스트림 생성 : list.stream()
        Stream<String> stream = list.stream();
        System.out.print("Collection.stream() : ");
        stream.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 배열로 스트림 생성 : Arrays.stream();
        Stream<String> stream2 = Arrays.stream(array); // String[]
        System.out.print("Arrays.stream() : ");
        stream2.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 배열의 일부로 스트림 생성 : Arrays.stream()
        Stream<String> stream3 = Arrays.stream(array, 1, 3);
        System.out.print("Arrays.stream(1,3) : ");
        stream3.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 가변 파라미터로 스트림 생성 : Stream.of()
        Stream<String> stream4 = Stream.of(array);
        System.out.print("Stream.of() : ");
        stream4.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 빈 스트림 생성 : Stream.empty()
        Stream<String> stream5 = Stream.empty();
        System.out.println("Stream.empty() : count " + stream5.count());

        // 지정된 범위 스트림 생성 (마지막 숫자 미포함) : IntStream.range()
        IntStream range = IntStream.range(5, 9);
        System.out.print("IntStream.range(5,9) : ");

        // 아래처럼 인터페이스를 활용한 방식으로 구현 가능
        /*
        range.forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value + " " );
            }
        });
        System.out.println();
        */

        // 지정된 범위 스트림 생성 (마지막 숫자 포함) : IntStream.rangeClose()
        IntStream rangeClosed = IntStream.rangeClosed(5, 9);
        System.out.print("IntStream.rangeClosed(5,9) : ");
        rangeClosed.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 난수 무한스트림 생성하여 3개 출력 : IntStream 사용
        IntStream ints = new Random().ints(0, 150);
        ints.limit(3).forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 무한 스트림 생성하여 5개 출력 : generate()
        Stream<String> generate = Stream.generate(() -> "generate");
        System.out.print("Stream.generate() : ");
        generate.limit(5).forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 난수 무한 스트림 생성하여 2개 출력 : generate()
        Stream<Double> generate2 = Stream.generate(Math::random);
        System.out.print("Stream.generate(Math::random) : ");
        generate2.limit(2).forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 초기값 1 에서 2씩 더해지는 무한스트림 생성하여 3개 출력 : iterate()
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 2);
        System.out.print("Stream.iterate() : ");
        iterate.limit(3).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }
}