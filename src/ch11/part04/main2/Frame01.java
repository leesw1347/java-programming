package ch11.part04.main2;

import javax.swing.*;
import java.awt.*;

public class Frame01 extends JFrame {
    public Frame01() throws HeadlessException {
//        super();
        // 화면 기본구성
        setTitle("Frame01");
        setLayout(null);
        setBounds(new Rectangle(0, 0, 300, 300));

        // 컴포넌트(텍스트) 생성
        JTextField text = new JTextField();
        text.setBounds(new Rectangle(10, 10, 200, 30));
        this.add(text);

        // 컴포넌트(버튼) 생성
        JButton btn = new JButton("현재시간");
        btn.setBounds(new Rectangle(10, 50, 150, 30));
        this.add(btn);
    }
}
