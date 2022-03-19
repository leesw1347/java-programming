package ch11.part02.main7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame01 extends JFrame {
    // 화면 B의 객체를 화면 A로 자료 전달을 하기 위해 frame02 속성 및 함수 정의
    private Frame02 frame02;

    public void setFrame02(Frame02 frame02) {
        this.frame02 = frame02;
    }

    public Frame01() {
        // 절차2. 메인화면설정
        this.setTitle("화면A");
        this.setLayout(null); // 배치를 수동(위치와 크기)으로 입력
        this.setSize(300, 200); // 화면 크기 설정

        // 절차3. 텍스트필드 객체생성 및 설정
        // 익명클래스 내 함수로 자료전달을 위해 final 키워드 사용
        final JTextField textField = new JTextField(); // 객체 생성
        textField.setBounds(new Rectangle(10, 10, 100, 30)); // 생성위치, 크기 설정
        this.add(textField); // 화면 추가

        // 절차4. 버튼 객체생성 및 설정
        JButton btn = new JButton("저장"); // 객체생성
        btn.setBounds(new Rectangle(120, 10, 100, 30)); // 생성위치, 크기 설정
        this.add(btn); // 화면 추가

        // 절차5. 버튼클릭 이벤트 생성(익명클래스 이용)
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 절차6. 버튼클릭 시 처리로직 구간작성
                // 버튼클릭 시 해당 내부로직 실행
                System.out.println("버튼클릭 이벤트 시작");

                // 화면 A frame01 객체의 지역변수 textField 자료 접근
                String text = textField.getText();

                // 화면 B frame02 객체의 setTextField() 함수사용
                frame02.setTextField(text);
            }
        });
    }
}
