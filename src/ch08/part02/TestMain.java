package ch08.part02;

import ch07.main1.part02.main1.TypeA;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 기본형 변수
         */
        int a = 3;
        int b = a; // a가 참조하는 값을 b에 복사

        /**
         * 자바에서는 method() 함수를 통하여 위에 있는 변수 a의 값을 변경할 수 없다
         */
        int c = method(a);
        System.out.println("동일변수 비교 = " + (a == b));

        /**
         * 참조형 변수
         */
        TypeA typeA1 = new TypeA();
        TypeA typeA2 = typeA1; // typeA1이 참조하는 주소를 typeA2에 복사

        // 자바에서는 method() 함수를 통하여 위의 객체 typeA1 주소를 변경할 수 없다
        TypeA typeA3 = method(typeA1);
        System.out.println("동일변수 비교 = " + (typeA1 == typeA2));
    }

    /**
     * 내부 클래스
     */
    public static class TypeA {

    }

    /**
     * 기본형 int 타입의 값을 변경하기 위한 함수
     */
    public static int method(int a) {
        a += 1;
        return a;
    }

    /**
     * TypeA 객체를 받아와 내부에서 새로운 메모리 주소를 갖는 객체를 생성
     */
    public static TypeA method(TypeA typeA) {
        typeA = new TypeA();
        return typeA;
    }

}
