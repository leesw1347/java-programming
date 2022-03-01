package ch07.part05.main3;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 타입 TypeA<String> -> <T extends TypeA<String>>
         */
        TypeB<TypeA<String>> typeB = new TypeB<TypeA<String>>();

        /**
         * 타입 TypeA<String> -> <T extends TypeA<Object>>
         */
//        TypeC<TypeA<Object>> typeC = new TypeC<TypeA<String>>();

        /**
         * 타입 TypeA<String> -> <T extends TypeA<?>>
         */
        TypeD<TypeA<String>> typeD = new TypeD<TypeA<String>>();
    }
}