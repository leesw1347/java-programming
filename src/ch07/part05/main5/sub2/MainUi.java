package ch07.part05.main5.sub2;

import javax.swing.*;
import java.awt.*;

public class MainUi extends JFrame {
    public MainUi() throws HeadlessException {
        this.setSize(300,300);

        /**
         * 1) 테이블 헤더와 자료 목록을 구성한다
         */
        String[] header = {"항목1", "항목2", "항목3"};
        String[][] data = {
                {"값11", "값12", "값13"},
                {"값21", "값22", "값23"},
                {"값31", "값32", "값33"}
        };

        /**
         * 2) 테이블을 생성 후 화면에 추가한다
         */
        JTable table = new JTable(data, header);

        /**
         * 3) 테이블에 스크롤과 헤더가 나타나도록 스크롤 패널을 생성한다
         */
        JScrollPane pane = new JScrollPane();

        /**
         * 4) 테이블을 스크롤 패널에 추가한다
         */
        pane.setViewportView(table);

        /**
         * 5) 패널을 메인 화면에 추가한다
         */
        this.add(pane);
    }

    public MainUi(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        MainUi mainUi = new MainUi();
        mainUi.setVisible(true); // 화면 visible true 설정
    }
}
