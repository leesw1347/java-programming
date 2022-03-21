package ch11.part04.main4;

import javax.swing.*;
import java.awt.*;

public class Frame02 extends MainFrame {

    // 컴포넌트 객체생성 구간
    private JTextField text = new JTextField();

    void setTextValue(String textValue) {
        text.setText(textValue);
    }

    // 생성자 함수
    public Frame02() {
        init();
    }

    // 초기화 함수
    // 컴포넌트 이벤트 처리
    protected void initEvent() {
    }

    // 컴포넌트 설정
    protected void initComponent() {
        // 컴포넌트(텍스트) 생성
        text.setBounds(new Rectangle(10, 10, 200, 30));
        this.add(text);
    }

    // 화면설정
    protected void initFrame() {
        // 화면 기본구성
        setTitle("Frame02");
        setLayout(null);
        setBounds(new Rectangle(400, 0, 300, 300));
    }
}
