package ch07.part06.main3.sub1;

import java.text.MessageFormat;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 클래스로부터 Class 타입 객체생성
         */
        Class<TypeA> clazz1 = TypeA.class;
        System.out.println(MessageFormat.format("클래스정보1:::{0}", clazz1));

        /**
         * 객체로부터 Class 타입 객체 생성
         */
        TypeA typeA = new TypeA();
        Class<? extends TypeA> clazz2 = typeA.getClass();
        System.out.println(MessageFormat.format("클래스정보 2:::{0}", clazz2));

        /**
         * 문자열로부터 Class 타입 객체 생성
         */
        try {
            Class clazz3 = Class.forName("ch07.part06.main3.sub1.TypeA");
            System.out.println(MessageFormat.format("클래스정보 3:::{0}", clazz3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}