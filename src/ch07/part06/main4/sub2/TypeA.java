package ch07.part06.main4.sub2;

import java.text.MessageFormat;

/**
 * Constructor를 이용한 객체 생성
 */
public class TypeA {
    /**
     * 전역변수 정의
     * 생성자 함수1 정의
     * 생성자 함수2 정의
     * toString() 함수 재정의
     */

    /**
     * 전역변수
     */
    private String name = "테스트";
    private int value = 1;

    /**
     * 생성자함수1
     */
    public TypeA() {
    }

    /**
     * 생성자함수2
     */
    public TypeA(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return MessageFormat.format("[name={0}.value={1}]", name, value);
//        return super.toString();
    }
}

