package ch12.part04.main7;

import java.util.HashMap;
import java.util.Map;

/**
 * 메인 객체 저장을 위한 클래스
 * 데이터의 저장은 applicationContainer에 저장하여 관리한다
 */
public class DataContainer {
    // 데이터 컨테이너 설정을 위한 applicationContainer 전역변수 정의
    private static final Map<String, Object> applicationContainer = new HashMap<>();

    // 데이터 저장을 위한 addBean() 함수 정의
    public static void addBean(String beanName, Object bean) {
        applicationContainer.put(beanName, bean);
    }

    // 데이터 호출을 위한 getBean() 함수 정의 [1]
    public static Object getBean(String beanName) {
        return applicationContainer.get(beanName);
    }

    // 제네릭스를 이용한 데이터 동적호출 getBean() 함수 정의 [2]
    public static <T> T getBean(String beanName, Class<T> clazz) {
        return (T) applicationContainer.get(beanName);
    }
}
