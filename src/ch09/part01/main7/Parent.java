package ch09.part01.main7;

public class Parent {
    // static 초기화 블록, 초기화 블록, 생성자 함수 정의

    // 정적(static) 초기화 블록
    static {
        System.out.println("\tParent 클래스 - 정적(static) 초기화 블록 구간");
    }

    /**
     * 초기화 블록
     */
    {
        System.out.println("\tParent 클래스 - 초기화 블록 구간");
    }

    /**
     * 생성자 함수1
     */
    public Parent() {
        System.out.println("\tParent 클래스 - 생성자함수 구간[1]");
    }

    /**
     * 생성자 함수2
     */
    public Parent(int a){
        System.out.println("\tParent 클래스 - 생성자함수 구간[2]");
    }
}
