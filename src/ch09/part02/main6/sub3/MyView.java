package ch09.part02.main6.sub3;

import ch09.part02.main6.sub2.ActionListenerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyView extends JFrame implements ActionListener {
    /**
     * 1. textField 전역변수 정의 : 생성자 함수와 공통 사용을 위함
     * 2. MyView 생성자 함수 정의 : 화면 구성
     * 메인 화면 화면 크기 설정
     */

    // 1.TextField 전역변수 정의, 생성자함수와 함수의 공통사용을 위함
    private JTextField textField = new JTextField();

    // 2. MyView 생성자함수 정의 - 화면구성
    public MyView() throws HeadlessException {
        // 메인화면 화면 크기 설정
        this.setSize(new Dimension(400, 200)); // 너비 400, 높이 200 픽셀

        // null의 경우, 컴포넌트 수동배치 설정, 크기와 위치를 직접 설정해야함
        this.setLayout(null);

        // 텍스트입력 컴포넌트(JTextField) 정의 및 위치, 크기 설정
        // JTextField textField = new JTextField(); 전역변수로 이동
        textField.setLocation(new Point(10, 10));
        textField.setSize(200, 30);

        // 버튼 컴포넌트(JButton) 정의 및 위치, 크기 설정
        JButton btn = new JButton("클릭");
        btn.setLocation(new Point(220, 10));
        btn.setSize(100, 30);

        // 텍스트 입력 컴포넌트 및 버튼을 메인화면에 추가
        this.add(textField);
        this.add(btn);

        // 버튼 클릭 이벤트 설정 - ActionEvent 인터페이스 사용
//        btn.addActionListener(this);

        // 버튼클릭 이벤트 설정 - ActionEvent 인터페이스 사용
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * 버튼클릭 이벤트 로직처리 구간 -> TextField에 특정 문자 입력
                 */
                textField.setText("익명클래스 인터페이스 구현");
            }
        });
    }

    /**
     * 메인함수 정의
     * 화면구동실행
     */
    public static void main(String[] args) {
        MyView myView = new MyView();
        myView.setVisible(true);
    }

    /**
     * 추상메소드 재정의(Override)
     * 버튼 클릭 이벤트 로직처리 구간 -> textField에 특정 문자 입력
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 버튼클릭 이벤트 로직처리 구간 - textField에 특정문자 입력
        textField.setText("자기 자신 클래스 인터페이스 구현");
    }
}
