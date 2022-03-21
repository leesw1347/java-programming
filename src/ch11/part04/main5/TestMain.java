package ch11.part04.main5;

public class TestMain {
    public static void main(String[] args) {
        // Frame01 객체생성 및 화면호출
        Frame01 frame01 = new Frame01();
        frame01.setVisible(true);

        // Frame02 객체생성 및 화면호출
        Frame02 frame02 = new Frame02();
        frame02.setVisible(true);

        // Frame02 객체를 Frame01로 객체전달
        frame01.setFrame02(frame02);
    }
}
