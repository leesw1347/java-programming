package ch11.part02.main6;

public class B {
    // B 클래스의 print() 함수에서 다른 곳에서 생성한 A 타입 a 객체를 가져와
    // 출력을 하기 위해 정의된 클래스이다.

    // print() 함수 정의
    public void print() {

        // DataContainer로부터 객체 a에 자료접근을 한다
        A a = DataContainer.a;
        String name = "";
        if (a != null) {
            name = a.getName();
        }
        System.out.println(name);
    }
}