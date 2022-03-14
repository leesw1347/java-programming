package ch09.part03.main1;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

// 추상클래스를 정의하기 위해선 abstract 키워드를 사용해서 정의한다
public abstract class AbstractMainView extends JFrame {
    // 화면명을 설정하기 위한 함수 정의
    public abstract String getTitle();

    // 시작 시 컴포넌트 설정 함수 정의
    public abstract void setInitLayout();

    // 시작 시 이벤트 설정 함수 정의
    public abstract void setInitEvent();

    // 화면을 다시 시작할 때 설정함수 정의
    public abstract void setOpenView();

    // 생성자 함수 정의

    public AbstractMainView() throws HeadlessException {
        System.out.println("AbstractMainView 생성자함수 실행");
        setLayout(null);
        setSize(400, 400);
    }

    // 화면 최초 open 이전 false, 이후 true
    private boolean isFirstOpen = false;

    // visible 속성 정의 - final: 더이상 재정의할 수 없도록 지정
    // setVisible 에서 하는 일을 유지시키고자 자식 클래스에서 재정의하지 못하도록 final 키워드 사용
    @NotNull
    @Override
    public final void setVisible(boolean visible) {
        System.out.println("AbstractMainView setVisible() 함수 실행");

        // 최초 객체생성 시 컴포넌트의 배치 및 이벤트처리를 한다.
        if (!isFirstOpen) {
            this.setTitle(getTitle());
            this.setInitLayout();
            this.setInitEvent();
        }

        // 화면을 띄울 때마다 세팅을 위한 함수를 실행한다
        if (visible) {
            setOpenView();
        }

        // 부모함수의 setVisible 함수 사용
        super.setVisible(visible);
    }
}