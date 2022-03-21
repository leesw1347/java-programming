package ch11.part04.main5;

import javax.swing.*;
import java.awt.*;

public class Frame02 extends MainFrame {
    // 컴포넌트 객체생성 구간
    private JTextField text = new JTextField();

    public void setTextValue(String textValue) {
        text.setText(textValue);
    }

    public Frame02() {
        init();
    }

    @Override
    public void init() {
        initFrame();
        initComponent();
        initEvent();
    }

    // 컴포넌트 객체생성 구간
    @Override
    protected void initFrame() {
        // 화면 기본 구성
        setTitle("Frame02");
        setLayout(null);
        setBounds(new Rectangle(400, 0, 300, 300));
    }

    // 컴포넌트
    @Override
    protected void initComponent() {
        // 컴포넌트(텍스트)생성
        text.setBounds(new Rectangle(10, 10, 200, 30));
        this.add(text);
    }

    @Override
    protected void initEvent() {
    }
}
