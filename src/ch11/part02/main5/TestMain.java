package ch11.part02.main5;

public class TestMain {

    public static void main(String[] args) {
        // A 타입의 count 정적변수 1 증가
        A.count += 1;

        // A 타입의  a01 객체 생성 및 count 정적 전역변수 1 증가
        A a01 = new A();
        a01.count++;
        System.out.println(a01);

        // A 타입의 a02 객체 생성 및 count 정적 전역변수 1 증가
        A a02 = new A();
        a02.count++;
        System.out.println(a02);

        // A 타입의 a03 객체 생성 및 count 정적 전역변수 1 증가
        A a03 = new A();
        a03.count++;
        System.out.println(a03);

        System.out.println(A.count);
    }
}
