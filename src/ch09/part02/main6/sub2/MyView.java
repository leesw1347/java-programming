package ch09.part02.main6.sub2;

import ch09.part02.main3.SystemManagerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 외부 클래스를 이용한 인터페이스 구현 클래스 정의를 할 수 있다
 * 메인 클래스 생성자 함수와 외부 클래스 함수와의 데이터 연결을 할 수 있다
 */
public class MyView extends JFrame {
    /**
     * 1. textField 전역변수 정의: 생성자 함수와 setText의 공통 사용을 위함
     * setTextField() 함수 정의 : 외부에서 textField의 text 속성값 변경
     * 2. MyView 생성자 함수 정의 : 화면구성 (ActionEvent 인터페이스 사용, 외부 클래스)
     * 3. 메인함수 정의
     */

    // textField 전역변수 정의, 생성자 함수와 setText()의 공통사용을 위함
    private JTextField textField = new JTextField();

    // setText() 함수 정의, 외부에서 textField의 text 속성 값 변경
    public void setText(String text) {
        if (text != null && text.length() > 0) {
            this.textField.setText(text);
        } else {
            this.textField.setText("텍스트가 비어있으므로 null 채움!");
        }
    }

    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public MyView() throws HeadlessException {
        // 메인화면 크기 설정
        this.setSize(new Dimension(400, 200)); // 너비400, 높이200

        // null의 경우 컴포넌트 수동배치 설정 - 크기와 위치를 직접 설정해야 함
        this.setLayout(null);

        // 텍스트입력 컴포넌트(JTextField) 정의 및 위치, 크기 설정
        // JTextField textField = new JTextField(); // 전역변수로 이동
        this.textField.setLocation(new Point(10, 10));
        this.textField.setSize(new Dimension(200, 30));


        JButton btn = new JButton("클릭");
        btn.setLocation(new Point(220, 10));
        btn.setSize(new Dimension(100, 30));

        // 텍스트입력 컴포넌트 및 버튼을 메인화면에 추가
        this.add(this.textField); // 화면에 컴포넌트 추가
        this.add(btn); // 화면에 컴포넌트 추가

        // 버튼클릭 이벤트 설정 - ActionEvent 인터페이스 사용 -> 외부클래스
        // this는 MyView 클래스의 '자기 자신' 객체를 뜻한다
        ActionListener action = new ActionListenerImpl(this);
        btn.addActionListener(action);
    }

    public static void main(String[] args) {
        MyView myView = new MyView();
        myView.setVisible(true);
    }
}
