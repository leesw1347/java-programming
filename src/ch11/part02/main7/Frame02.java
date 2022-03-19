package ch11.part02.main7;

import javax.swing.*;
import java.awt.*;

public class Frame02 extends JFrame {

    // 전역변수 textField 정의 후 지역변수 textField와 연결
    private JTextField textField;

    public Frame02(){
        // 화면설정
        this.setTitle("화면B"); // 화면명을 수정
        this.setLayout(null); // 배치를 수동(위치와 크기)으로 입력
        this.setSize(new Dimension(300,200)); // 화면 생성위치, 크기 설정
        this.setLocation(new Point(450, 0));

        // 텍스트필드 생성 및 설정
        JTextField textField = new JTextField(); // 객체생성

        // 전역변수 textField 정의 후 지역변수 textField와 연결
        this.textField = textField;

        textField.setBounds(new Rectangle(10,10,100,30));
        this.add(textField);
    }

    // 파라미터의 값을 전역변수 textField에 입력
    public void setTextField(String text) {
        if (text != null){
            textField.setText(text);
        }
    }
}
