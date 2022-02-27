package ch07.main1.part03.main1.sub1;

import java.text.MessageFormat;

public class MyButton {
    /**
     * 버튼의 캡션 정보 전역변수 정의
     * 버튼의 위치 정보 전역변수 정의
     * 버튼의 위치 정보 타입 정의
     *  버튼의 위치 속성 정의
     *  버튼 정보 toString() 재정의
     */

    /**
     * 버튼의 캡션정보
     */
    private String caption;

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return this.caption;
    }

    /**
     * 버튼의 위치정보
     */
    public PositionInfo positionInfo = new PositionInfo();

    public PositionInfo getPositionInfo() {
        return positionInfo;
    }

    /**
     * 버튼의 위치정보타입 정의
     */
    public class PositionInfo {
        /**
         * 버튼 위치속성 정의
         */
        public int x;
        public int y;
        public int width;
        public int height;

        /**
         * 버튼정보 toString() 재정의
         */
        @Override
        public String toString() {
//            return super.toString();
            String msg = MessageFormat.format(
                    "PositionInfo[x={0}, y={1}], width=[{2}], height=[{3}]",
                    x, y, width, height);
            return msg;
        }
    }
}
