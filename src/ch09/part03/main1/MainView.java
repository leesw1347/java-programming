package ch09.part03.main1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends AbstractMainView {

    private JButton btn = new JButton("버튼");

    // ChildView 호출을 위한 객체생성
    private ChildView childView = new ChildView();

    // 초기화블록 - 컴포넌트 기본설정
    {
        System.out.println("MainView 초기화 구간 실행");
        btn.setBounds(new Rectangle(10, 50, 100, 40));
    }

    // 화면명을 설정하기 위한 함수 재정의
    @Override
    public String getTitle() {
        return "메인화면";
    }

    // 시작 시 컴포넌트 설정함수 재정의
    @Override
    public void setInitLayout() {
        System.out.println("MainView initLayout() 실행");
        this.add(btn);
    }

    // 시작 시 이벤트 설정함수 재정의
    @Override
    public void setInitEvent() {
        System.out.println("MainView initEvent() 실행");

        // 익명클래스를 이용한 버튼클릭 이벤트 처리
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ChildView 화면 나타내기
                childView.setVisible(true);
            }
        });
    }

    // 화면을 다시 시작할 때 설정함수 재정의
    @Override
    public void setOpenView() {
        System.out.println("MainView openView() 실행");
    }
}
