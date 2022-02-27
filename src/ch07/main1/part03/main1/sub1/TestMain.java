package ch07.main1.part03.main1.sub1;

import ch07.main1.part03.main1.sub1.MyButton.PositionInfo;

import java.text.MessageFormat;

public class TestMain {
    /**
     * 메인 함수 정의
     * 버튼 객체 생성
     * 버튼 제목 설정
     * 버튼 위치 설정
     * 버튼 정보 조회
     */
    public static void main(String[] args) {
        /**
         * 버튼 객체 생성
         */
        MyButton btn = new MyButton();

        /**
         * 버튼 제목설정
         */
        btn.setCaption("저장");

        /**
         * 버튼 위치설정
         */
        PositionInfo positionInfo = btn.getPositionInfo();
        positionInfo.x = 100;
        positionInfo.y = 100;
        positionInfo.width = 200;
        positionInfo.height = 40;

        /**
         * 버튼정보 조회
         */
        System.out.println(MessageFormat.format("버튼 제목정보 = {0}", btn.getCaption()));
        System.out.println(MessageFormat.format("버튼 위치정보 = {0}", positionInfo));
    }
}
