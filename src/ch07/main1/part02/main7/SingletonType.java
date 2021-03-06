package ch07.main1.part02.main7;

public class SingletonType {
    /**
     * 동일타입의 객체를 반환하기 위해 전역변수 정의
     */
    private static SingletonType type = null;

    /**
     * private 생성자 함수
     */
    private SingletonType() {

    }

    /**
     * @return
     * @summar
     * @since 2022.02.27
     */
    public static SingletonType getInstance() {
        if (type == null) {
            type = new SingletonType();
        }
        return type;
    }
}
