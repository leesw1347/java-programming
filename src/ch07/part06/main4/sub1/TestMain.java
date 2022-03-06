package ch07.part06.main4.sub1;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;
import java.util.Arrays;

public class TestMain {
    /**
     * 메인 함수 정의
     * Class 타입 객체 생성
     * 명시된 생성자 함수 정보를 가져옴
     * 기본 생성자 함수 정보 조회
     * 파라미터 타입이 String, int인 생성자 함수 조회
     */
    public static void main(String[] args) {
        /**
         * Class 타입 객체생성
         */
        Class clazz = TypeA.class;

        /**
         * 명시된 전체 생성자함수 객체목록 조회
         */
        Constructor[] constructors = clazz.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));

        for (Constructor c : constructors) {
            System.out.println(MessageFormat.format("생성자함수 목록 {0}", c));
        }

        try {
            /**
             * 기본 생성자함수 정보 조회
             */
            Constructor constructor2 = clazz.getDeclaredConstructor();
            System.out.println(constructor2);

            /**
             * 파라미터 타입이 String, int인 생성자함수 조회
             */
            Constructor constructor3 = clazz.getDeclaredConstructor(String.class, Integer.TYPE);
            System.out.println(constructor3);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
