package ch09.part02.main5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyView extends JFrame implements ActionListener {
    private JTextField textField = new JTextField();

    /**
     * 객체생성 시 컴포넌트를 구성하기위해 생성자함수에 구현
     */
    public MyView() throws HeadlessException {
        setLayout(null);
        setSize(400, 200); // 메인화면 크기 - 너비 400 픽셀, 높이 200 픽셀

        /**
         * 텍스트입력 컴포넌트 정의 및 위치, 크기설정
         */
        // JTextField textField = new JTextField(); 전역변수로 이동
        textField.setLocation(10, 10); // 위치설정
        textField.setSize(200, 30); // 크기설정
        this.add(textField); // 화면에 컴포넌트 추가

        // 버튼 컴포넌트 정의 및 위치, 크기 설정
        JButton btn = new JButton("클릭");
        btn.setLocation(220, 10); // 위치설정
        btn.setSize(100, 30); // 크기설정
        this.add(btn); // 화면에 컴포넌트 추가

        /**
         * 버튼 클릭 이벤트 처리
         */
        ActionListener action = new ActionEventImpl();
        btn.addActionListener(action);
    }

    public static void main(String[] args) {

        // 4. 익명클래스를 이용한 인터페이스 구현 클래스 정의
        // 클래스명이 존재하지 않으며, 클래스 정의와 함께 객체를 생성한다
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 *  로직 구현
                 */
            }
        };

       MyView myView = new MyView();
        myView.setVisible(true);
    }

    /**
     * 자기 자신을 클래스를 이용한 인터페이스 구현 클래스 정의
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * 로직구현
         */
    }

    /**
     * 1. 내부 클래스를 이용한 인터페이스 구현 클래스 정의
     * 버튼 이벤트를 구현하기 위한 ActionListener 인터페이스 구현클래스
     */
    public class ActionEventImpl implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * 텍스트 입력 컴포넌트에 test라는 문자열의 값을 입력
             */
            textField.setText("test");
        }
    }
}

/**
 * 2. 외부 클래스를 이용한 인터페이스 구현 클래스 정의
 * 독립적인 클래스로 정의하여 처리
 * MyView 클래스 외에 공통으로 같이 사용해야 할 경우, 일반적으로 독립된 인터페이스로 구현한다
 */
class ActionEventImpl implements ActionListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         *
         */
    }
}
