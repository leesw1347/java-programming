package ch09.part01.main3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestMain {
    public static class A {

    }

    public static void main(String[] args) {
        /**
         * TestMain 클래스 class 객체 생성
         */
        Class clazz = TestMain.class;

        /**
         * TestMain 클래스의 부모클래스 조회 - Object 클래스
         */
//        System.out.println(clazz);
        Class superClass = clazz.getSuperclass(); // TestMain 클래스의 부모 클래스를 조회하도록 한다
        System.out.println(superClass);

        /**
         * 부모클래스 (Object)의 필드정보 조회
         */
        Field[] fields = superClass.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("전역변수 = " + f.getName());
        }

        /**
         * 부모클래스(Object)의 함수 정보 조회
         */
        Method[] methods = superClass.getDeclaredMethods();
        for (Method m : methods) {
            String name = m.getName();
            String parameterTypes = Arrays.toString(m.getParameterTypes());
            System.out.println("함수 = " + name + " : " + parameterTypes);
        }

        A a = new A();
        int hashCode = a.hashCode();
        /**
         * Integer 함수 - 16진수 변환 : toHexString()
         */
        String hexHashCode = Integer.toHexString(hashCode);
        String toString = a.toString();

        /**
         * toString() 정보는 "클래스명@해시코드" 임을 알 수 있다
         */
        System.out.println(toString + " : " + hexHashCode);
    }
}