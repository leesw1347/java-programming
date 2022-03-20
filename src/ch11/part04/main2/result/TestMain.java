package ch11.part04.main2.result;

public class TestMain {

    public static void main(String[] args) {
        // Frame01 객체생성 및 화면호출
        Frame01 frame1 = new Frame01();
        frame1.setVisible(true);

        // Frame02 객체생성 및 화면호출
        Frame02 frame2 = new Frame02();
        frame2.setVisible(true);

        // Frame02 객체를 Frame01로 객체전달
        frame1.setFrame02(frame2);
    }
}
