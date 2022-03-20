package ch11.part03.main3;

public class B {
    public void method1(String no) {
        if (no.equals("1") || no.equals("2")) {
            System.out.println("B 클래스 method1() 함수 로직처리1");
        } else {
            System.out.println("B 클래스 method1() 함수 로직처리2");
        }
    }
}
