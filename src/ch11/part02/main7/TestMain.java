package ch11.part02.main7;

public class TestMain {
    // 메인 클래스의 메인 함수를 실행하여 다음 화면과 같이 나타내도록 한다
    public static void main(String[] args) {
        // 화면 A frame01 객체생성 및 화면출력
        Frame01 frame01 = new Frame01();
        frame01.setVisible(true);

        // 화면 B frame02 객체생성 및 화면출력
        Frame02 frame02 = new Frame02();
        frame02.setVisible(true);

        // 화면B frame02 객체 -> 화면 A frame01 객체로 자료전달
        frame01.setFrame02(frame02);
    }
}