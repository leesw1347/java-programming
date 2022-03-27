package ch12.part05.main1.sub5;

import java.util.Properties;
import java.util.Set;

public class TestMain {
    // System 클래스는 자바의 설정 정보를 제공하며 이에 대한 정보를 Properties 타입으로 제공한다
    public static void main(String[] args) {
        // 시스템 정보 조회
        Properties properties = System.getProperties();
        Set<Object> keySet = properties.keySet();
        for (Object o : keySet) {
            System.out.println(o + ":" + properties.get(o));
        }
    }
}
