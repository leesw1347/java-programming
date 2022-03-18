package ch11.part01.main7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    public MainView(String name) {
        // 배치를 수동(위치와 크기)으로 입력
        this.setLayout(null);

        // 화면크기 설정
        this.setSize(300, 200);

        // 텍스트 컴포넌트 생성
        JTextField textField = new JTextField();
        textField.setBounds(new Rectangle(10, 10, 100, 30));

        // 버튼 생성
        JButton btn = new JButton("저장");
        btn.setBounds(new Rectangle(120,10,100,30));
        this.add(btn);
        this.add(textField);

        // 버튼 이벤트 생성
        // 버튼 클래스의 이벤트 구현 객체는 익명클래스로 정의되어 있으며, 외부의
        // name 변수와 textField 객체를 익명 클래스 내 함수로 접근 시키기 위한 작업이 필요하다
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼클릭 시 내부 로직이 실행됨
                // 버튼 클릭 시 파라미터 name의 변수 값을 textField에 나타내시오
                textField.setText(name);
            }
        });
    }

    public static void main(String[] args) {
        MainView mainView = new MainView("테스트");
        mainView.setVisible(true);
    }
}
