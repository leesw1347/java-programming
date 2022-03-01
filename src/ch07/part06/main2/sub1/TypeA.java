package ch07.part06.main2.sub1;

/**
 * 리플렉션을 이용한 객체 생성
 * 리플렉션을 이용한 함수 생성 및 함수 호출
 */
public class TypeA {
    /**
     * name 속성 정의
     * 기본 생성자 및 생성자 함수 정의
     * name 속성 getter setter 함수 정의
     * static 함수 정의
     */

    // name 속성 정의
    private String name;

    // 생성자함수 정의
    public TypeA() {
    }

    public TypeA(String name) {
        this.name = name;
    }

    // name 속성 getter setter 함수 정의
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // static 함수 정의
    public static void method1() {
        System.out.println("TypeA, method1() - static method1 함수 호출");
    }
}