package ch07.part06.main6;

import java.lang.reflect.Method;

public class TestMain {
    /**
     * 메인함수 정의
     * Class 타입 객체 생성
     * 전체 함수 정보
     * 전체 public 함수 정보
     * 개별 함수 정보 getName()
     * 개별 함수 정보 setName()
     * 개별 함수 정보 setValue() - int.class 파라미터의 처리
     * 개별 함수 정보 setValue() - Integer.TYPE 파라미터의 처리
     * int 타입 -> Integer.class의 경우 오류 발생
     * 개별 함수 정보 setValue() - Integer.class 파라미터 오류 발생
     */
    public static void main(String[] args) {
        /**
         * Class 타입 객체 생성
         */
        Class clazz = TypeA.class;

        /**
         * 전체 함수정보
         */
        TypeA typeA = new TypeA();
        System.out.println("-- 전체 함수 정보 -- ");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName() + "\t" + m.canAccess(typeA));
        }

        /**
         * 전체 public 함수 정보
         */
        System.out.println("\r\n 전체 public 함수정보 ----");
        for (Method m : methods) {
            System.out.println(m.getName() + "\t" + m.canAccess(typeA) + "\t" + m);
        }

        try {
            /**
             * 개별 함수 정보 getName()
             */
            System.out.println("\r\n 개별 함수정보 getName() ----");
            Method method2 = clazz.getDeclaredMethod("getName");
            System.out.println(method2);

            /**
             * 개별 함수 정보 setName()
             */
            System.out.println("\r\n 개별 함수정보 setName() ----");
            Method method3 = clazz.getDeclaredMethod("setName", String.class);
            System.out.println(method3);

            /**
             * 개별 함수 정보 setValue() - int.class 파라미터의 처리
             */
            System.out.println("\r\n 개별 함수정보 setValue() int.class 파라미터의 처리----");
            Method method4 = clazz.getDeclaredMethod("setValue", int.class);
            System.out.println(method4);

            /**
             * 개별 함수 정보 setValue() - Integer.TYPE 파라미터의 처리
             */
            System.out.println("\r\n Integer.TYPE 타입의 처리 - 개별 함수정보 setValue()----");
            Method method5 = clazz.getDeclaredMethod("setValue", Integer.TYPE);
            System.out.println("함수정보 5 ::: " + method5);

            /**
             * 개별 함수정보 setValue() - Integer.class 파라미터 오류 발생
             */
//            Method method6 = clazz.getDeclaredMethod("setValue", Integer.class)
//            System.out.println(method6);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}