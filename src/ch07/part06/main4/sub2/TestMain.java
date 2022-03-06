package ch07.part06.main4.sub2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

public class TestMain {
    /**
     * 메인 함수 정의
     * Class 타입 객체 생성
     * Class 객체를 이용한 객체 생성
     * Constructor 객체를 이용하여 객체 생성하기
     */
    public static void main(String[] args) {
        /**
         * Class 객체생성
         */
        Class clazz = TypeA.class;
        try {
            /**
             * Class 객체를 이용한 객체생성
             */
            Object obj1 = clazz.newInstance();
            TypeA test1 = (TypeA) obj1;
            System.out.println(MessageFormat.format("class 객체를 이용한 객체생성 : {0}", test1));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            /**
             * Constructor 객체를 이용하여 객체 생성하기
             */
            Constructor constructor = clazz.getConstructor(String.class, Integer.TYPE);
            Object obj2 = constructor.newInstance("테스트1", 21);
            TypeA test2 = (TypeA) obj2;
            System.out.println(MessageFormat.format("Constructor 객체를 이용한 객체생성 : {0}", test2));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
