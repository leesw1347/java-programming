package ch09.part03.main3.sub;

public class ChildClass extends AbstractClass {

    // method1() 함수가 호출되는 시점은 AbstractClass의 생성자 함수 호출 시
    // 호출되기 때문에, name 변수는 선언되지 않았기 때문에 nullpointer Exception이 생긴다
    private String name = "자식클래스변수";

    @Override
    public void method1() {
        int length = name.length(); // length(): 글자의 길이를 나타내는 함수
        System.out.println("글자의 길이 = " + length);
    }
}