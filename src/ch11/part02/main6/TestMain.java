package ch11.part02.main6;

// 자료 연결을 위해 정적 전역변수를 이용하는 과정을 이해하도록 한다
public class TestMain {

    public static void main(String[] args) {
        // 객체생성
        A a = new A();
        B b = new B();

        // 객체생성된 자료를 데이터 컨테이너에 객체를 저장한다
        DataContainer.a = a;
        DataContainer.b = b;

        // 객체 a에 전역변수 name에 "a.name.value" 라는 값을 넣는다
        a.setName("a.name.value");

        // 객체 b의 print() 함수사용
        b.print();
    }
}