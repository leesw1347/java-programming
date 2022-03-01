package ch07.part06.main2.sub2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;

public class TestMain {
    public static void main(String[] args)
            throws Exception {
        /**
         * 1. 동적으로 Class 객체를 가져오기 (ProductVo 클래스 동적 로딩)
         */
        Class clazz = Class.forName("ch07.part06.main2.sub2.ProductVo");
        System.out.println(MessageFormat.format("동적 로딩 클래스는 claszz {0}", clazz));

        /**
         * 2. 생성자함수 호출하기 - ProductVo(String productName, int price);
         * 생성자 함수의 파라미터가 String, int 인 생성자 함수 관리 클래스 객체 조회
         * clazz 객체는 ProductVo 클래스의 Class 타입 객체이며, 다음의 생성자 함수를 조회한 것이다
         *  public ProductVo(String productName, int price) { ... }
         */
        Constructor constructor = clazz.getConstructor(String.class, int.class);

        /**
         * 3. Constructor를 이용해서 객체 생성
         *  ProductVo obj = new ProductVo("테스트2", 2); 와 같은 결과를 얻는다
         *  모든 클래스의 상위 클래스는 Object 클래스이다.
         *  모든 타입은 Object 입니다
         *  하지만 모든 Object는 ProductVo 타입이라고 할 수 없습니다
         */
        Object obj = constructor.newInstance("테스트2", 2);
        System.out.println(MessageFormat.format("객체정보 {0}", obj));

        /**
         * 4. productName의 속성정보 객체 호출
         * productName의 전역변수를 관리하는 Field 타입 객체를 조회
         */
        Field field = clazz.getDeclaredField("productName");

        /**
         * 5. productName 속성의 접근여부 확인 (private 속성은 false)
         * Field 타입 객체를 통하여 해당 전역변수의 접근 가능 여부를 조회
         * 접근이 가능할 경우 값을 조회하거나 변겨알 수 있다
         */
        boolean isAccessible = field.isAccessible();
        System.out.println(MessageFormat.format("field에 접근이 가능한가요?{0}", isAccessible));

        /**
         * 6. productName 속성에 직접 접근이 가능하도록 설정
         * Field 타입 객체를 통하여 해당 전역변수의 접근 가능 여부를 설정
         * 접근이 가능하도록 설정할 수 있다
         */
        field.setAccessible(true); // private 속성은 접근이 불가능하기 때문에 접근 가능하도록 수정

        /**
         * 7. obj(ProductVo 클래스의 생성자 객체)의 productName 속성의 값 조회
         * 접근이 가능한 상태에서 전역변수의 값을 조회할 수 있다.
         */
        Object nameFieldValue = field.get(obj);
        System.out.println("productName 속성의 값 ;;; " + nameFieldValue);

        /**
         * 8. productName 속성의 값 변경
         * 해당 전역변수의 값을 변경할 수 있다
         */
        field.set(obj, "테스트3");
        System.out.println(MessageFormat.format("productName 속성의 값 ::: {0}", field.toString()));

        /**
         * 9. name 속성의 접근 여부를 회복
         */
        field.setAccessible(false);

        /**
         * 10. getPrice() 함수 관리 객체 호출 및 함수 실행
         */
        Method method = clazz.getDeclaredMethod("getPrice");
        Object returnVal1 = method.invoke(obj); // obj의 객체에 대한 getPrice 함수 실행
        System.out.println(MessageFormat.format("getPrice() 함수 호출결과 ::: {0}", returnVal1));

        /**
         * 11. setPrice() 함수 관리 객체 호출
         */
        Method method2 = clazz.getDeclaredMethod("setPrice", int.class);
        Object returnVal2 = method2.invoke(obj, 3);
        System.out.println(MessageFormat.format("setPrice() 함수 호출결과 ::: {0}", returnVal2));
        System.out.println(MessageFormat.format("객체정보 {0}", obj));
    }
}
