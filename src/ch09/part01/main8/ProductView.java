package ch09.part01.main8;

import javax.swing.*;

// module-info.java 파일에 'requires java.desktop' 모듈 추가
public class ProductView extends JFrame {
    // JFrame 클래스를 상속하여 JFrame이 제공하는 기능을 그대로 사용할 수 있음

    /**
     * JFrame 클래스 상속
     * 생성자 함수 생성
     *  타이틀 설정 -> 크기 설정 -> 위치 설정
     *
     *  메인함수 정의,
     *   객체 생성 visible true
     */

    /**
     * 생성자함수
     */
    public ProductView() {
        /**
         * 타이틀설정 -> 크기설정 -> 위치설정
         */
        this.setTitle("제품 관리 화면");
        this.setSize(400, 300);
        this.setLocation(200, 200);
    }

    /**
     * 메인함수 정의
     */
    public static void main(String[] args) {
        /**
         * 객체생성 -> visible true
         */
        ProductView view = new ProductView();
        view.setVisible(true);
    }
}