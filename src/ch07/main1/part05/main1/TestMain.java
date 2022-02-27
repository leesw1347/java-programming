package ch07.main1.part05.main1;

import java.text.MessageFormat;

public class TestMain {
    /**
     * 메인함수 정의
     * TypeB 객체 생성 -> method1(), method2() 함수 사용
     * TypeA 객체 생성 - 제네릭 타입 사용 -> 제네릭 타입 반환
     * TypeA 객체 생성 - 제네릭 타입 사용 안 함 - Object 타입 반환
     */
    public static void main(String[] args) {
        /**
         * TypeB 객체 생성 - method1(), method2() 함수 사용
         */
        TypeB b = new TypeB(); /* TypeB 객체 생성 */
        String method1 = b.method1("테스트1");
        String method2 = TypeB.method2("테스트2");

        System.out.println(MessageFormat.format("{0}, {1}", method1, method2));

        /**
         * TypeA 객체 생성 - 제네릭 타입 사용 -> 제네릭 타입 반환
         */
        TypeA<String> a1 = new TypeA<String>("1");
        String t1 = a1.getT();
        System.out.println(t1);

        /**
         * TypeA 객체 생성 - 제네릭 타입 사용 안 함 -> Object 타입 반환
         */
        TypeA a2 = new TypeA("2");
        Object t2 = a2.getT();
        Object method6 = b.method3(a2);
        Object method5 = TypeB.method4(a2);

        System.out.println(MessageFormat.format("t2 {0}", t2));
        System.out.println(MessageFormat.format("method6 {0}, {1}", method5, method6));
    }
}