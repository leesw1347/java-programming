package ch09.part01.main10;

import javax.swing.*;

public class TestMain {
    public static void main(String[] args) {
        /**
         * JFrame 클래스 Class 객체를 이용하여 getSuperClass() 함수 호출
         */
        Class clazz = JFrame.class;
        getSuperClass(clazz);
    }

    /**
     * 재귀함수를 통하여 해당 클래스의 상위클래스 조회함수
     *
     * @param clazz Object > Componenet > Container > Window > Frame > JFrame
     */
    private static void getSuperClass(Class clazz) {
        if (clazz == null) {
            return;
        }
        System.out.println("클래스명 = " + clazz.getName());

        /**
         * 상위클래스 조회
         */
        Class superclass = clazz.getSuperclass();
        if (superclass != null) {
            getSuperClass(superclass);
        }
    }
}