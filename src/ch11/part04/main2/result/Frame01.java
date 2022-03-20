package ch11.part04.main2.result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Frame01 extends JFrame {
    // Frame2 객체를 Frame01에 연결시키기 위해서 사용함
    private Frame02 frame02;

    public void setFrame02(Frame02 frame02) {
        this.frame02 = frame02;
    }

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

        // 버튼클릭 이벤트처리
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar calendar = Calendar.getInstance();
                String msg = calendar.getTime().toString();
                text.setText(msg);
                frame02.setTextValue(msg);
            }
        });
    }
}
