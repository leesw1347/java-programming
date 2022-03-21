package ch11.part04.main5;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Frame01 extends MainFrame {

    // 컴포넌트 객체생성 구간
    private JTextField text = new JTextField(); // 익명클래스 접근
    private JButton btn = new JButton("현재시간");

    // 자료연결을 위해 전역변수 및 함수 생성
    private Frame02 frame02;

    public void setFrame02(Frame02 frame02) {
        this.frame02 = frame02;
    }

    public Frame01() {
        init();
    }

    @Override
    public void init() {
        initFrame();
        initComponent();
        initEvent();
    }

    @Override
    protected void initFrame() {
        // 화면 기본 구성
        setTitle("Frame01");
        setLayout(null);
        setBounds(new Rectangle(0, 0, 300, 300));
    }

    @Override
    protected void initComponent() {
        // 컴포넌트(텍스트) 생성
        text.setBounds(new Rectangle(10, 10, 200, 30));
        this.add(text);
        // 컴포넌트(버튼) 생성
        btn.setBounds(new Rectangle(10, 50, 150, 30));
        this.add(btn);
    }

    @Override
    protected void initEvent() {
        // 버튼클릭 이벤트 정의
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // 버튼클릭 시 이벤트 로직 구성
                Calendar calendar = Calendar.getInstance();
                String msg = calendar.getTime().toString();
                text.setText(msg);
                frame02.setTextValue(msg);
            }
        });
    }
}
