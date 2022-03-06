package ch07.part06.main6.sub2;


import ch07.part06.main6.TypeA;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;

public class TestMain {
    public static void main(String[] args) {
        /**
         * Class 타입 객체 생성 - 객체생성
         */
        Class clazz = TypeA.class;
        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        /**
         * 함수 실행 전 조회
         */
        TypeA test = (TypeA) obj;
        System.out.println(MessageFormat.format("변경 전 :: name[{0}]", test.getName()));
        System.out.println(MessageFormat.format("변경 전 :: value[{0}]", test.getValue()));

        /**
         * 개별 함수 정보 조회
         */
        try {
            Method method1 = clazz.getDeclaredMethod("getName");
            Method method2 = clazz.getDeclaredMethod("setName", String.class);
            Method method3 = clazz.getDeclaredMethod("getValue");
            Method method4 = clazz.getDeclaredMethod("setValue", int.class);

            /**
             * 개별 함수 실행
             */
            Object result1 = method1.invoke(test);
            Object result2 = method2.invoke(test, "테스트2");
            Object result3 = method3.invoke(test);
            Object result4 = method4.invoke(test, 2);

            /**
             * 함수 실행 후 조회
             */
            System.out.println(MessageFormat.format("변경 후 ::: name[{0}]", test.getName()));
            System.out.println(MessageFormat.format("변경 후 ::: value[{0}]", test.getValue()));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
