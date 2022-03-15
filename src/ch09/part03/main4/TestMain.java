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
        // 상속, 인터페이스와 같이 추상 클래스도 업캐스팅과 다운캐스팅이 가능하다
        ChildClass c = new ChildClass();

        // 2. 업 캐스팅 - 형변환 연산자 생략가능
        // c 객체는 ChildClass 객체이며, 상위 클래스로의 형 변환이 가능하다
        // 업 캐스팅의 경우 생략이 가능하다 ()로 묶어서 형 변환하는 과정은 생략이 가능하다
        AbstractClass c1 = (AbstractClass) c;

        // 3. 다운 캐스팅 - 형변환 연산자 생략 불가능
        // instanceof 연산자는 객체의 타입을 비교하는 연산자임
        if (c1 instanceof ChildClass) {
            // c1이 ChildClass일 경우, true, 아닐경우 false 값을 가진다
            ChildClass c2 = (ChildClass) c1;
        }

        System.out.println(c);
        System.out.println(c1);
    }
}