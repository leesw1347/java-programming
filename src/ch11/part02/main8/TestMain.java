package ch11.part02.main8;

public class TestMain {
    public static void main(String[] args) {
        // 화면 A frame01 객체생성 및 화면출력
        Frame01 frame01 = new Frame01();
        frame01.setVisible(true);

        // 화면 B frame02 객체생성 및 화면출력
        Frame02 frame02 = new Frame02();
        frame02.setVisible(true);

        // DataContainer에 객체등록
        DataContainer.frame01 = frame01;
        DataContainer.frame02 = frame02;
    }
}
