package ch11.part02.main8;

import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 절차1. 화면생성을 위해 JFrame 상속
public class Frame01 extends JFrame {

    // 절차2. 메인화면설정
    public Frame01() throws HeadlessException {
        this.setTitle("화면A");
        this.setLayout(null); // 배치를 수동(위치와 크기)으로 입력
        this.setSize(new Dimension(300,200)); // 화면 크기 설정

        // 절차3. 텍스트필드 객체생성 및 설정
        // 익명 클래스 내 함수로 자료전달을 위해 [final] 키워드 사용
        final JTextField textField = new JTextField(); // 객체생성
        textField.setBounds(new Rectangle(10,10,100,30)); // 생성위치, 크기 설정
        this.add(textField); // 화면추가

        // 절차4. 버튼 객체생성 및 설정
        JButton btn = new JButton("저장"); // 객체생성
        btn.setBounds(new Rectangle(120,10,100,30));
        this.add(btn); // 화면추가

        // 절차5. 버튼클릭 이벤트 생성(익명클래스 이용)
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 절차6. 버튼클릭 시 처리로직 구간작성
                // 버튼클릭 시 해당 내부로직 실행
                System.out.println("버튼클릭 이벤트 시작");

                // 화면A frame01 객체의 지역변수 textField 자료접근
                String text = textField.getText();

                // DataContainer에서 화면 B frame2 객체조회
                Frame02 frame02 = DataContainer.frame02;

                // 화면 B frame02 객체의 setTextField() 함수 사용
                frame02.setTextField(text);
            }
        });
    }
}
