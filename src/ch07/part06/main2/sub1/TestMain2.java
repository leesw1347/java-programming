package ch07.part06.main2.sub1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * 리플렉션을 이용하여 객체 생성 및 함수 호출을 하였으며, TestMain1 클래스의 실행 결과와
 * 동일한 결과를 갖는다
 */
public class TestMain2 {
    /**
     * 예외처리를 위해 아래와 같이 'throws Exception' 처리를 하자
     */

    // 예외 처리 방법 중의 하나이며, 예외를 위임하기 위한 정의 방법
    public static void main(String[] args) throws Exception {
        // TypeA a1 = new TypeA();
        Class forName = null;
        try {

            /**
             * String 타입을 Class 타입으로 동저 객체 생성
             * String 타입으로 패키지를 포함한 클래스의 정식 명칭을 입력
             * Class 클래스는 자바의 클래스를 관리하기 위한 클래스임
             */
            forName = Class.forName("ch07.part06.main2.sub1.TypeA");

            /**
             * Class 타입 객체 'forName'을 이용하여 객체 생성을 하였다
             * new TypeA()를 호출한 것과 같다
             * String 타입 객체 -> Class 타입 객체 -> 객체 생성
             */
            Object a1 = forName.newInstance();

            // String name1 = a1.getName();
            Method method1 = forName.getMethod("getName");
            Object name1 = method1.invoke(a1);
            System.out.println(MessageFormat.format("a1 name = {0}", name1));

            // a1.setName("name2");
            Method method2 = forName.getMethod("setName", String.class);
            method2.invoke(a1, "name2");

            // TypeA a2 = new TypeA("name3");

            /**
             * Class 타입 객체 forName을 이용하여 함수를 관리하는 Constructor 클래스 객체를
             * 호출할 수 있다
             */
            Constructor constructor = forName.getDeclaredConstructor(String.class);

            // Constructor 클래스 객체를 이용해서,객체 생성
            Object a2 = constructor.newInstance("name3");
            System.out.println(a2);

            // String name3 = a2.getName();
            Object name3 = method1.invoke(a2);
            System.out.println(MessageFormat.format("a2 name = {0}", name3));

            // TypeA.method()
            Method method3 = forName.getDeclaredMethod("method1");
            method3.invoke(null);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}