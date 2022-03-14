package ch09.part03.main1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChildView extends AbstractMainView {

    // 값을 입력하기 위한 텍스트 테스트필드 컴포넌트 객체 생성
    private JTextField textField1 = new JTextField("textField");
    private JTextField textField2 = new JTextField("");

    // 값의 항목명을 입력하기 위한 라벨 컴포넌트 객체 생성
    private JLabel label1 = new JLabel("화면오픈시 활성화 및 초기화, 버튼클릭 시 비활성화");
    private JLabel label2 = new JLabel("이전 화면 값 유지");

    // 버튼 컴포넌트 객체생성
    private JButton btn1 = new JButton("버튼을 클릭하시오.");

    // 초기화블록 - 컴포넌트 기본설정
    {
        textField1.setBounds(new Rectangle(10, 60, 200, 20));
        textField2.setBounds(new Rectangle(10, 85, 200, 20));

        label1.setBounds(new Rectangle(250, 60, 400, 20));
        label2.setBounds(new Rectangle(250, 85, 400, 20));

        btn1.setBounds(new Rectangle(10, 115, 200, 20));
    }

    // 화면명을 설정하기 위한 함수 재정의
    @Override
    public String getTitle() {
        return "ChildView 화면";
    }

    // 시작 시 컴포넌트 설정함수 재정의
    @Override
    public void setInitLayout() {
        // 메인화면 기본설정
        this.setAlwaysOnTop(true);
        this.setLocation(new Point(500, 0));
        this.setSize(new Dimension(600, 300));

        // 버튼,라벨,텍스트필드 객체를 메인화면에 추가
        this.add(btn1);
        this.add(label1);
        this.add(textField1);
        this.add(textField2);
    }

    @Override
    public void setInitEvent() {
        // 익명클래스를 이용한 버튼클릭 이벤트처리
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 데이터 생성 - 로직 생략
                String data = "버튼 클릭 시 비활성화";
                // 화면 이벤트 종료 이후 컴포넌트에 자료 넣기
                textField1.setText(data);
                // 화면 종로 후 컴포넌트 활성화/비활성화 처리
                textField1.setEnabled(true);
            }
        });
    }

    @Override
    public void setOpenView() {
        // 텍스트필드1 초기화 및 컴포넌트 활성화
        textField1.setText("");
        textField1.setEnabled(true);
    }
}
