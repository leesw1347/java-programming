package ch12.part04.main7;

public class TestMain {

    public static void main(String[] args) {
        // frame01, controller, service 객체생성
        Frame01 frame01 = new Frame01();
        Controller controller = new Controller();
        Service service = new Service();

        // DataContainer에 저장
        DataContainer.addBean("frame01", frame01);
        DataContainer.addBean("controller", controller);
        DataContainer.addBean("service", service);

        // 화면이 나타나도록 설정
        frame01.setVisible(true);
    }
}
