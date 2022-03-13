package ch09.part02.main6.sub1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyView extends JFrame {
    /**
     * textField 전역 변수 정의: MyView 생성자 함수와 내부 클래스 공통 사용 목적
     */
    private JTextField textField = new JTextField("NULL");

    /**
     * MyView 생성자 함수 정의 : 화면 구성
     * 1. 메인화면 크기 설정
     * 2. null의 경우, 컴포넌트 수동배치 설정 : 크기와 위치 직접 설정
     * 3. 텍스트 입력 컴포넌트(JTextField) 정의 및 위치, 크기 설정
     * 4. 버튼 컴포넌트(JButton) 정의 및 위치, 크기 설정
     * 5. 텍스트 입력 컴포넌트 및 버튼을 메인 화면에 추가
     * 6. 버튼 클릭 이벤트 설정 : ActionEvent 인터페이스 사용 -> 내부 클래스
     */
    public MyView() {
        // 메인화면 크기 설정 (너비400, 높이 200)
        this.setSize(new Dimension(400, 200));

        // null의 경우 컴포넌트 수동배치 설정 - 크기와 위치를 직접 설정해야함
        this.setLayout(null);

        // 텍스트입력 컴포넌트(JTextField) 정의 및 위치, 크기 설정
        // JTextField textField = new TextField() -> 전역변수로 이동
        textField.setLocation(new Point(10, 10));
        textField.setSize(new Dimension(200, 30));

        /**
         * 버튼 컴포넌트(JButton) 정의 및 위치, 크기 설정
         */
        JButton btn = new JButton("클릭");
        btn.setLocation(new Point(220, 10));
        btn.setSize(100, 30); // 너비 100, 높이 30 픽셀

        // 텍스트입력 컴포넌트 및 버튼을 메인 화면에 추가
        this.add(textField); // 화면에 컴포넌트 추가
        this.add(btn); // 화면에 컴포넌트 추가

        // 버튼 클릭 이벤트 설정 - ActionEvent 인터페이스 사용 - 내부클래스
        ActionListener action = new ActionListenerImpl();
        btn.addActionListener(action);
    }

    /**
     * 메인함수 정의 : 화면구동 실행
     */
    public static void main(String[] args) {
        MyView myView = new MyView();
        myView.setVisible(true);
    }

    /**
     * ActionListener 구현 클래스 정의
     * 추상 메소드 재정의
     * 버튼 클릭 이벤트 로직 처리 구간, textField에 특정 문자 입력
     */
    private class ActionListenerImpl implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // 버튼클릭 이벤트 처리로직 구간 - textField에 특정문자 입력
            textField.setText("내부 클래스 인터페이스 구현");
        }
    }
}
