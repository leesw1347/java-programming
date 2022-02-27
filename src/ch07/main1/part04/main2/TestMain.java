package ch07.main1.part04.main2;

public class TestMain {
    /**
     * 메인 함수 정의
     * Gender.MAN
     * Gender.WOMAN 자료 선택
     */

    public static void main(String[] args) {
        Gender gender1 = Gender.MAN;
        int value1 = gender1.getValue();
        String name1 = gender1.getName();

        System.out.println("Gender.MAN value = " + value1);
        System.out.println("Gender.MAN name = " + name1);

        /**
         * Gender.WOMAN 자료 선택
         */
        Gender gender2 = Gender.WOMAN;
        int value2 = gender2.getValue();
        String name2 = gender2.getName();

        System.out.println("Gender.WOMAN value = " + value2);
        System.out.println("Gender.WOMAN name = " + name2);
    }
}
