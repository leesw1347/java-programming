package ch09.part01.main4;

public class Child extends Parent {

    /**
     * 전역변수 정의
     */
    private int value = 2;

    {
        /**
         * [비고1] 변수 print()
         */
        System.out.println("name = " + name); // 부모필드
        System.out.println("value = " + value); // 자식 필드
//        System.out.println(type); // 오류발생 - 주석처리

        /**
         * [비교2] super.변수 print() - 부모필드
         */
        System.out.println("super.name = " + super.name);
        System.out.println("super.value = " + super.value);
//        System.out.println(this.type); // 오류발생 - 주석처리

        /**
         * [비교3] this.변수 print()
         */
        System.out.println("this.name = " + this.name); // 부모필드
        System.out.println("this.value = " + this.value); // 자식필드
        // System.out.println(this.type); // 오류 발생 - 주석처리

        /**
         * 부모 클래스의 enum 접근
         */
        System.out.println("Type.A = " + Type.A);
    }

    public static void main(String[] args) {
        new Child();
    }
}
