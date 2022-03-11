package ch09.part01.main9;

import javax.swing.*;

// Object -> JFrame -> MainView -> ProductView
public class MainView extends JFrame {
    /**
     * JFrame 클래스 상속
     * 개별 화면의 공통 로직을 여기에서 처리
     */
    public MainView(String title, int width, int height, int x, int y) {
        /**
         * 개별 화면의 공통 로직을 여기에서 처리할 수 있다
         */
        this.setTitle(title);
        this.setSize(width, height);
        this.setLocation(x, y);
    }
}