package ch07.main2.sub3;

public class TestMain {
    public static void main(String[] args) {

        /**
         * TypeC 객체 생성
         */
        TypeC c = new TypeC();

        /**
         * TypeC 객체로 TypeB의 함수사용
         */
        int value = c.getValue();

        /**
         * TypeC 객체로 TypeA의 함수사용
         */
        String name = c.getName();
    }
}