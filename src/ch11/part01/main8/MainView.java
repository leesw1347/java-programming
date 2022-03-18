package ch11.part01.main8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    // 전역변수 name
    private String name;

    public MainView() throws HeadlessException {
    }

    // 객체 생성 시 name 값을 받아와 전역변수 name에 담는다
    public MainView(String name) throws HeadlessException {
        this.name = name;

        // 배치를 수동(위치와 크기)으로 입력
        this.setLayout(null);

        // 화면 크기 설정
        this.setSize(new Dimension(300,200));

        // 텍스트 컴포넌트 생성
        JTextField textField = new JTextField();
        textField.setBounds(new Rectangle(10,10,100,30));
        this.add(textField);

        // 버튼 생성
        JButton btn = new JButton("저장");
        btn.setBounds(new Rectangle(120,10,100,30));
        this.add(btn);

        // 버튼 이벤트 생성
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼클릭 시 내부 로직이 실행됨
                // 버튼 클릭 시 전역변수 name의 변수 값을 textField에 나타내시오

                // 전역변수의 익명 클래스 내의 접근
                // 전역변수 name은 익명 클래스 내부에 접근이 가능하지만, 익명 클래스가 정의된
                // 함수 내에서 지역변수 name과 중복되기 때문에, 지역변수와 구분하여 접근을 시켜야 한다
                // ch11.part07.main7.MainView.this.name
                // 전역변수를 호출하기 위한 최소 변수명은 MainView.this.name이 된다
                textField.setText(MainView.this.name);
            }
        });
    }

    public static void main(String[] args) {
        MainView mainView = new MainView("테스트");
        mainView.setVisible(true);
    }
}
