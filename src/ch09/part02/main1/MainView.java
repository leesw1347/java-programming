package ch09.part02.main1;

import javax.swing.*;
import java.awt.*;

/**
 * 인터페이스를 이용한 버튼 클릭 이벤트 구현처리
 * 인터페이스를 이용하여 팝업창을 처리하기 위한 모듈을 구성
 * 익명클래스를 이용하여 인터페이스 구현 객체 정의
 */
public class MainView extends JFrame { // MainView 클래스는 JFrame을 상속 받은 클래스임
    /**
     * 생성자 함수 정의
     * MainView 클래스를 상속받은 클래스는 아래의 로직이 공통 적용됨
     * 배치 설정 수동 처리 - 수동처리 시 크기와 위치를 설정해야 함
     * MainView의 기본 사이즈를 가로 300px, 세로 200px로 설정
     */

    /**
     * MainView 클래스를 상속 받은 클래스는 아래의 로직이 공통적용됨
     */
    public MainView() throws HeadlessException {
        /**
         * 배치설정 수동처리 - 수동처리 시 크기와 위치를 설정해야 함
         */
        setLayout(null);

        /**
         * MainView의 기본 사이즈를 가로 300px, 세로 200px로 설정
         */
        setSize(300, 200);
    }
}