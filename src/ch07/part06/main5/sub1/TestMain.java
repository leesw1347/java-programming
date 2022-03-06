package ch07.part06.main5.sub1;

import java.lang.reflect.Field;
import java.text.MessageFormat;

/**
 * 속성 정보 Field 객체 조회하기
 */
public class TestMain {
    /**
     * 메인 함수 정의
     * Class 타입 객체 생성
     * 클래스에 정의된 모든 속성 정보를 가져옴
     * 클래스에 정의된 모든 public 속성 정보를 가져옴
     * 개별 속성 정보 조회
     */

    public static void main(String[] args) {
        /**
         * Class 타입 객체 생성
         */
        Class clazz = TypeA.class;

        /**
         * 클래스에 정의된 모든 속성정보를 가져옴
         */
        System.out.println("----- 전체속성정보 -----");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(MessageFormat.format("{0}\t{1}", f.getName(), f.isAccessible()));
        }
        System.out.println();

        /**
         * 클래스에 정의된 모든 public 속성정보를 가져옴
         */
        System.out.println("----- public 전체속성정보 -----");
        Field[] fields2 = clazz.getFields();
        for (Field field : fields2) {
            System.out.println(MessageFormat.format("{0}, {1}, {2}", field.getName(), field.isAccessible(), field));
        }

        /**
         * 개별 속성정보 조회
         */
        System.out.println("----- value 속성정보 -----");
        try {
            Field f = clazz.getDeclaredField("value");
            System.out.println(MessageFormat.format("{0}, {1}, {2}", f.getName(), f.isAccessible(), f));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}