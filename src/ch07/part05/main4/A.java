package ch07.part05.main4;

import javax.swing.*;

/**
 * Swing 이용하여 화면 구상하기
 * 1) JFrame 클래스 상속
 * 2) 화면 크기 설정
 * 3) 화면에 보이도록 설정
 */

public class A extends JFrame { // 1) JFrame 클래스 상속

    public A() { // 생성자 함수를 통해서 JFrame의 setSize 함수 실행
        this.setSize(300, 300); // 2) 화면크기 설정
    }

    public static void main(String[] args) {
        A a = new A();
        a.setVisible(true);
    }
}
