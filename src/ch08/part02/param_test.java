package ch08.part02;


public class param_test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        /**
         * 열거를 이용한 동적 파라미터의 이용
         */
        a.print("a","b","c","d","e");

        /**
         * 배열을 이용한 함수의 이용
         */
        String[] array = {
                "a","b","c","d","e"
        };
        a.print(array); // 동적 파라미터도 배열로 입력받을 수 있다
        b.print(array);
    }
}
