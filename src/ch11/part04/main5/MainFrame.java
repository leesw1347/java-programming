package ch11.part04.main5;

import javax.swing.*;

public abstract class MainFrame extends JFrame {
    // 생성자함수 정의
    public MainFrame() {
//        init();
    }

    // 외부에서도 사용할 수 있도록 public 설정함
    public abstract void init();

    // 화면설정
    protected abstract void initFrame();

    // 컴포넌트 설정
    protected abstract void initComponent();

    // 컴포넌트 이벤트 처리
    protected abstract void initEvent();
}
