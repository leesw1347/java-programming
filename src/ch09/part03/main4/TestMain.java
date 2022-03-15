package ch09.part03.main4;

public class TestMain {
    /**
     * 메인 함수 정의
     * ChildClass 객체 생성
     * 업캐스팅 - 형 변환 연산자 생략 가능
     * 다운캐스팅 - 형 변환 연산자 생략 불가능
     */


    public static void main(String[] args) {
        // 1. ChildClass 객체생성
        ChildClass c = new ChildClass();

        // 2. 업 캐스팅 - 형변환 연산자 생략가능
        AbstractClass c1 = (AbstractClass) c;

        System.out.println(c);
        System.out.println(c1);
    }
}