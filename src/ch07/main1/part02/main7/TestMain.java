package ch07.main1.part02.main7;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 싱글톤 패턴 객체
         * 싱글톤 패턴으로 객체를 생성할 경우에는 'new' 연산자를 사용하지 않는다
         */
        SingletonType type1 = SingletonType.getInstance();
        SingletonType type2 = SingletonType.getInstance();

        /**
         * 메모리 주소비교
         */
        if (type1 == type2) {
            System.out.println("a1 객체와 a2 객체의 메모리 주소는 같습니다");
        } else {
            System.out.println("a1 객체와 a2 객체는 메모리 주소가 다릅니다");
        }
    }
}
