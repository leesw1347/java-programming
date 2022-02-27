package ch07.main1.part04.main1;

public class TestMain {
    public static void main(String[] args) {
        /**
         * TypeA 객체 생성
         */
        TypeA a = new TypeA();

        /**
         * 자료의 입력은 '타입.속성명' 형태로 입력을 한다
         */
        a.setGenderType(TypeA.GenderType.MAN);

        /**
         * 비교는 연산자 '=='로 할 수 있다
         */
        if (a.getGenderType() == TypeA.GenderType.MAN) {
            System.out.println("객체비교 a.getGenderType()[남자]");
        } else if (a.getGenderType() == TypeA.GenderType.WOMAN) {
            System.out.println("객체비교 a.getGenderType()[여자]");
        } else {
            System.out.println("비교불가");
        }
    }
}