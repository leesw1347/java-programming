package ch09.part01.main7;

public class Child extends Parent {
    // Parent 클래스 상속
    // static 초기화 블록, 초기화 블록, 생성자 함수 정의

    /**
     * 정적 (static) 초기화 블록
     */
    static {
        System.out.println("\tChild 클래스 - 정적(static) 초기화블록 구간");
    }

    /**
     * 초기화블록
     */ {
        System.out.println("\tChild 클래스 - 초기화블록 구간");
    }

    /**
     * 생성자함수1
     */
    public Child() {
        System.out.println("\tChild 클래스 - 생성자함수 구간");
    }

    /**
     * 생성자함수2
     */
    public Child(int a) {
        super(a);
        System.out.println("\tChild 클래스 - 생성자함수 구간");
    }
}
