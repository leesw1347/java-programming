package ch08.part02;

public class A {
    /**
     * 동적 파라미터 사용
     */

    // 반환 타입의 동적 처리 정의
    // 함수의 제네릭 타입을 정의한다
    // 함수의 목적은 파라미터로 들어오는 동적 파라미터를 배열로 변환해 반환하는 함수를 만들고자 한다
    public <T> T[] method(T... t) {
        T[] array = t;
        return array;
    }

    public void print(String... msg) {
        if (msg == null) {
            return;
        }
        String[] messages = msg;
        for (String s : messages) {
            System.out.println(s);
        }
    }
}
