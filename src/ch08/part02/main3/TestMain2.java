package ch08.part02.main3;

public class TestMain2 {
    /**
     * static method() 함수 정의
     * 파라미터 객체의 count 속성값 변경
     * <p>
     * 메인 함수 정의
     * TypeA 객체 생성 및 속성 설정
     * 함수 사용 -> TypeA 객체를 파라미터로 사용, 함수에서 객체의 속성 변경
     * 변수 속성 변경 여부 확인
     * 속성값의 변경이 있다 (함수 실행 후 속성값의 영향이 있다)
     */

    // static method() 함수 정의
    public static void method(TypeA a) {
        // 파라미터 객체의 count 속성 값 변경
        a.setCount(a.getCount() + 1);
//        System.out.println(a.getCount()); // count = 1
    }

    public static void main(String[] args) {

        /**
         * TypEA 객체생성 및 속성설정
         */
        TypeA a = new TypeA();
        a.setCount(1);
        System.out.println(a.getCount()); // count = 1

        /**
         * 함수 사용 - TypeA 객체를 파라미터로 사용, 함수에서 객체 속성 변경
         */
        method(a);

        /**
         * 변수속성 변경여부 확인
         */
        System.out.println(a.getCount()); // count = 2
    }
}
