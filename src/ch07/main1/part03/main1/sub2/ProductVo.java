package ch07.main1.part03.main1.sub2;

public class ProductVo {
    /**
     * 전역변수 정의
     * 품목 그리드 관련 공통 정보 타입 정의
     * -> 품목 그리드 헤더 정보
     * -> 품목 그리드 너비 정보
     */
    private String productNo;
    private String productName;
    private String price;

    /**
     * 품목 그리드관련 공통정보타입 정의
     * 정적 내부 클래스 (static inner class)
     */
    public static class TableInfo {
        /**
         * 품목 그리드 헤더정보
         */
        public final static String[] HEADER_INFO = {"품목번호", "품목명", "단가"};
        /**
         * 품목 그리드 너비정보
         */
        public final static int[] WIDTH_INFO = {100, 400, 100};
    }
}
