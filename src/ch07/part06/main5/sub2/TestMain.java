package ch07.part06.main5.sub2;

import ch07.part06.main5.sub1.TypeA;

import java.lang.reflect.Field;
import java.text.MessageFormat;

/**
 * Field 객체를 이용한 전역변수 관리
 */
public class TestMain {
    public static void main(String[] args) {
        /**
         * 메인함수 정의
         *  Class 객체 호출
         *  TypeA 객체 생성
         *  속성명 name과 일치하는 Field 객체 호출
         *  name 속성에 접근 여부 조회
         *  name 속성에 접근 가능하도록 설정
         *  name 속성값 조회
         *  name 속성값 "테스트2"로 변경
         *  name 속성값 다시 조회
         *  name 속성에 접근 여부 원래대로 설정
         */

        try {
            /**
             * 1. Class 객체 호출
             */
            Class clazz = TypeA.class;
            /**
             * 2. TypeA 객체 생성
             */
            Object obj = clazz.newInstance();
            /**
             * 3. 속성명 name과 일치하는 Field 객체 호출
             */
            Field nameField = clazz.getDeclaredField("name");
            /**
             * 4. name 속성에 접근 여부 조회
             */
//            boolean accessible = nameField.canAccess();
            /**
             * 5. name 속성에 접근가능하도록 설정
             */
            nameField.setAccessible(true);
            /**
             * 6. name 속성 값 조회
             */
            Object fieldObj = nameField.get(obj);
            System.out.println(MessageFormat.format("변겅 전 name 속성 값 ::: {0}", fieldObj));
            /**
             * 7. name 속성 값 '테스트2'로 변경
             */
            nameField.set(obj, "테스트2");
            /**
             * 8. name 속성 값 다시 조회
             */
            Object fieldObj2 = nameField.get(obj);
            System.out.println(MessageFormat.format("변경 후 name 속성 값 ::: {0}", fieldObj2));
            /**
             * 9. name 속성에 접근여부 원래대로 설정
             */
            nameField.setAccessible(false);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}