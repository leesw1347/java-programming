package ch11.part04.main2;

import javax.swing.*;
import java.awt.*;

public class Frame02 extends JFrame {
    public Frame02() throws HeadlessException {
//        super();

        // 화면 기본구성
        setTitle("Frame02");
        setLayout(null);
        setBounds(new Rectangle(400, 0, 300, 300));

        // 컴포넌트(텍스트) 생성
        JTextField text = new JTextField();
        text.setBounds(new Rectangle(10, 10, 200, 30));
        this.add(text);
    }
}
