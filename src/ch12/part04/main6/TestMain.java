package ch12.part04.main6;

public class TestMain {
    public static void main(String[] args) {

        // 객체생성
        Frame01 frame01 = new Frame01();
        Frame02 frame02 = new Frame02();
        System.out.println(frame01);
        System.out.println(frame02);

        // 공유데이터 저장
        // 객체 자료 연결 처리 절차
        DataContainer.addBean("frame01", frame01);
        DataContainer.addBean("frame02", frame02);

        // 화면 view 설정
        frame01.setVisible(true);
        frame02.setVisible(true);

    }
}
