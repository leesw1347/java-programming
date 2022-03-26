package ch12.part04.main6;

import java.util.HashMap;
import java.util.Map;

public class DataContainer {
    // 데이터 컨테이너 설정을 위한 applicationContainer 전역변수 정의
    // 객체 관리를 위한 정적(static) 변수 정의
    private static final Map<String, Object> applicationContainer = new HashMap<>();

    // 데이터 저장을 위한 addBean() 함수 정의
    public static void addBean(String beanName, Object bean) {
        applicationContainer.put(beanName, bean);
    }

    // 데이터 호출을 위한 getBean() 함수 정의[1]
    public static Object getBean(String beanName) {
        return applicationContainer.get(beanName);
    }

    // 제네릭스를 이용한 데이터 동적호출 getBean() 함수 정의[2]
    // 최초 함수를 사용하는 곳에서 파라미터로 입력된 clazz 변수의 타입을 반환 타입으로 동적 제어한다
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return (T) applicationContainer.get(beanName);
    }
}