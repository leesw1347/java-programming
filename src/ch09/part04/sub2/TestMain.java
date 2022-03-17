package ch09.part04.sub2;

public class TestMain {

    public interface A<T> {
        public T[] method(T... t);
    }

    public static void main(String[] args) {
        /**
         * 제네릭스를 고려한 A 타입 객체 생성
         * 익명 클래스에서도 타입명에 제네릭 타입을 다음과 같이 명시할 수 있다
         */
        A<Integer> a = new A<Integer>() {
            @Override
            public Integer[] method(Integer... t) {
                System.out.println("method1() 함수 재정의");
                for (Integer i : t) {
                    System.out.println(i);
                }
                return t;
            }
        };
        Integer[] value = a.method(1, 2, 3, 4, 5);
        /**
         * 제네릭스를 고려한 A 타입 객체생성
         * 두번째 제네릭 타입명을 생략할 수 있으며, '<>'만 명시하면 된다
         */
        A<Integer> aa = new A<>() {
            @Override
            public Integer[] method(Integer... t) {
                System.out.println("method1() 함수 재정의");
                for (Integer i : t) {
                    System.out.println(i);
                }
                return t;
            }
        };
        Integer[] value2 = aa.method(6, 7, 8, 9, 10);
    }
}