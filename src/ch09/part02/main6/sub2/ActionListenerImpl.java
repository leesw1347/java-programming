package ch09.part02.main6.sub2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerImpl implements ActionListener {
//     * 1. MyView 타입 myView 전역변수 정의
//     * 2. 생성자 함수 정의
//     *  MyView 객체 myView를 파라미터로 사용하여 데이터 연결
//     * 3. 추상메소드 재정의(Override)
//     * myView.setText() -> textField에 특정 문자 입력
//     */

    // MyView 타입 myView 전역변수 정의
    private MyView myView;

    // 생성자 함수 정의
    public ActionListenerImpl(MyView myView){
        // MyView 객체를 파라미터로 사용하여 데이터 연결
        this.myView = myView;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 버튼클릭 이벤트 로직처리 구간
        // myView.setText() -> TextField에 특정문자 입력
        myView.setText("외부클래스 인터페이스 구현");
    }
}
