package ch19.part03;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.text.MessageFormat;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestMain {
    public static void main(String[] args) {
        // Null 변환 자료 조회
        /*
        Optional<String> empty = Optional.empty();
        empty.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                // 반환할 결과 값을 로직 처리
                return "결과 값";
            }
        });
        */
        Optional<String> empty = Optional.empty();
        String result = empty.orElseGet(() -> "no value");

        // public Optional<T> or(Supplier<T> supplier)
        // Optional 내부 자료가 값을 가질 경우 Optional 객체를 그대로 반환하며, 값이 없으면 Supplier의 get()
        // 함수에 의해 생성된 Optional 객체 변환

        Optional<String> empty2 = Optional.empty();

//        Optional<String> result2 = empty.or(new Supplier<Optional<? extends String>>() {
//            @Override
//            public Optional<? extends String> get() {
//                return Optional.empty();
//            }
//        });

        // 사용 예 - 람다사용 (익명클래스 사용 예를 람다로 전환)
        Optional<String> empty3 = Optional.empty();
        Optional<String> result3 = empty3.or(() -> Optional.of("no value"));
        System.out.println(result3.get());

        // public Optional<T> filter(Predicate<? extends T> predicate)
        // 해당 함수가 필터 조건에 맞는 경우 해당 값을 가진 Optional 객체를 반환하며, 그렇지 않을 경우 값이 없는
        // Optional 객체를 반환
        Optional<Integer> of = Optional.of(123);
        Optional<Integer> filter1 = of.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer > 100) return true;
                else return false;
            }
        }); // 결과 -> filter1의 123의 값을 찾는 Optional<Integer> 객체

        Optional<Integer> filter2 = of.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer < 100) return true;
                else return false;
            }
        }); // filter2는 값이 존재하지 않는 Optional<Integer> 객체

        Optional<Integer> filter11 = of.filter(t -> {
            if (t > 100) {
                return true;
            } else {
                return false;
            }
        });

        Optional<Integer> filter22 = of.filter(t -> {
            if (t < 100) {
                return true;
            } else {
                return false;
            }
        });

        System.out.println("filter1의 결과 값 : " + filter11.get());
        try {
            Optional<Integer> of22 = of.of(50);
            of22.filter(t -> {
                if (t < 100) {
                    return true;
                } else {
                    return false;
                }
            });
            System.out.println(MessageFormat.format("of.of(50) {0}", of22.get()));
            System.out.println("filter2의 결과 값 : " + filter22.get());
        } catch (NoSuchElementException ex) {
//            ex.printStackTrace();
        }

        // public Optional<U> map(Function<? extends T, ? extneds U> function)
        // Optional<T> 객체를 Optional<U> 타입의 객체로 변호나하고, 내부의 값을 해당 U 타입으로 변환 시킨다
        Optional<Integer> of22 = Optional.of(1);
        Optional<String> of222 = of.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        }); // 문자 "1"을 갖는 Optional<String> 객체 리턴
        Optional<String> of223 = of22.map(t -> String.valueOf(t));
        System.out.println("of.map 결과 : " + of223.get());
        System.out.println("of223.valueOf의 값은 " + of223.get() instanceof String);

        // public void ifPresent(Consumer<? extends T> consumer>
        // 값이 존재할 때만 해당 consumer 객체의 함수를 실행하며, 값이 없을 경우 실행하지 않는다.
//        Optional<Integer> of33 = Optional.of(1);
        Optional<Integer> of33 = Optional.empty();
        of33.ifPresent(
                new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        // 값이 있을 경우, 처리로직 구간
                        System.out.println("값 = " + String.valueOf(integer));
                    }
                }
        );
        // 사용 예 - 람다 사용 (익명클래스 사용 예를 람다로 전환)
        Optional<Integer> of331 = Optional.of(1);
        of331.ifPresent(integer -> System.out.println(
                MessageFormat.format("값={0}", integer)
        ));

        // public void ifPresentOrElse(Consumer<? extends T> consumer, Runnable r)
        // 값이 존재할 때만 해당 consumer 객체의 accept() 함수를 실행하며, 값이 없을 경우 r 객체의 run() 함수를 실행
//        Optional<Integer> of44 = Optional.of(1);
        Optional<Integer> of44 = Optional.empty();
        of44.ifPresentOrElse(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                // 값이 있을 경우 처리 로직 구간
                System.out.println("값 : " + String.valueOf(integer));
            }
        }, new Runnable() {
            @Override
            public void run() {
                // 값이 없을 경우 로직 처리 구간
                System.out.println("값이 존재 안함");
            }
        });

        // Optional<Integer> of = Optional.of(1);
        of44.ifPresentOrElse(
                t -> System.out.println("값 = " + t),
                () -> System.out.println("값이 존재하지 않음")
        );
    }
}