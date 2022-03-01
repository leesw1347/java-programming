package ch07.part06.main2.sub1;

import java.text.MessageFormat;

public class TestMain1 {

    public static void main(String[] args) {
        /**
         * TypeA a1 객체생성
         */
        TypeA a1 = new TypeA();

        /**
         * a1 getName() 함수호출
         */
        String name1 = a1.getName();
        System.out.println(MessageFormat.format("a1 name = {0}", name1));

        /**
         * a1 setName() 함수호출
         */
        a1.setName("name2");

        /**
         * a1 getName() 함수호출
         */
        String name2 = a1.getName();
        System.out.println(MessageFormat.format("a2 name = {0}", name2));

        /**
         * TypeA a2 객체생성 - 두번째 생성자함수 사용
         */
        TypeA a2 = new TypeA("name3");
        String name3 = a2.getName();
        System.out.println(MessageFormat.format("a2 name ", name3));

        // static 함수 호출
        TypeA.method1();
    }
}
