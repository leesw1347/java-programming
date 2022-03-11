package ch09.part02.main1;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch09.part02.main1.ConfirmUtil.ConfirmWindowWork;

public class TestView extends MainView {
    /**
     * 생성자 함수 정의
     *
     * ActionListener 인터페이스 : 이벤트 구현을 위한 클래스
     * 버튼 클릭 시 actionPerfomred() 함수를 실행한다
     */

    /**
     * 생성자 함수 정의
     *
     * @throws HeadlessException
     */
    public TestView() throws HeadlessException {

        // 버튼 컴포넌트 객체생성 및 크기, 위치지정
        JButton btn = new JButton("저장");
        btn.setBounds(new Rectangle(10, 10, 100, 30));

        /**
         * 버튼 클릭 시, 이벤트 처리를 위한 객체 생성
         */
        ButtonAction action = new ButtonAction();

        /**
         * 버튼 클릭 이벤트 설정
         */
        btn.addActionListener(action);

        /**
         * 화면에 버튼 컴포넌트 추가하기
         */
        this.add(btn);
    }

    // ActionListener 인터페이스 - 이벤트 구현을 위한 클래스
    public class ButtonAction implements ActionListener {

        // 버튼클릭시 actionPerformed() 함수를 실행한다
        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * 예, 아니오 팝업창 모듈사용
             */
            ConfirmUtil.confirmWindow(TestView.this,
                    new ConfirmUtil.ConfirmWindowWork() {
                        @Override
                        public String yesWork() {
                            /**
                             * "예" 처리를 위한 로직구현 구간
                             */
                            return "예를 선택하였습니다";
                        }

                        @Override
                        public String noWork() {
                            /**
                             * "아니요" 처리를 위한 로직구현 구간
                             */
                            return "아니요를 선택하였습니다";
                        }
                    });
        }
    }

    public static void main(String[] args) {
        TestView view = new TestView();
        view.setVisible(true);
    }
}
