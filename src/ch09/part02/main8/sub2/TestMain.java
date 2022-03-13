package ch09.part02.main8.sub2;

public class TestMain {

    public static void main(String[] args) {
        /**
         * ChildImpl 객체 생성 및 함수 사용
         */
        System.out.println("ChildImpl 객체생성 및 함수실행");
        ChildImpl t1 = new ChildImpl();
        t1.method1();
        t1.method2();
        t1.method3();
        t1.method4();

        /**
         * 업캐스팅 및 상위타입 함수 실행
         */
        System.out.println("업캐스팅 - IParent 타입 함수실행");
        IParent t2 = t1;
        t2.method1();
        t2.method2();
        t2.method3();
//        t2.method4(); [오류발생] 접근불가하여 오류 발생

        /**
         * 업캐스팅 객체 다운캐스팅
         */
        System.out.println("다운캐스팅 - ChilImpl 타입 함수실행");
        ChildImpl t3 = (ChildImpl) t2;
        t3.method1();
        t3.method2();
        t3.method3();
        t3.method4(); // 사용가능
    }
}