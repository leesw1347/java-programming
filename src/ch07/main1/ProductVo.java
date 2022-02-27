package ch07.main1;

import java.text.MessageFormat;

public class ProductVo {
    /**
     * 속성 - 품목번호, 품목명, 단가 정의
     * 객체 생성 개체 수 저장을 위해 count 변수 설정
     * 품목 번호는 count 변수를 활용하여 a001 과 같이 4자리 문자열로 표현
     * 1)내부클래스(Inner Class) TableInfo 정의
     *  항목명을 String[] 타입으로 정의
     *  항목 너비를 int[] 타입으로 정의
     * 2) ProductVo 항목을 String[] 으로 반환하는 함수 생성
     */

    /**
     * 정적(static) 전역변수 - 객체수를 저장하기 위한 목적으로 정의
     */
    private static int count;

    /**
     * enum 타입
     */
    public enum DataType {
        INSERT, UPDATE, DELETE, NORMAL
    }

    /**
     * 전역변수
     */
    private String productNo; // 품목번호
    private String productName; // 품목명
    private int price; // 단가

    /**
     * 전역변수 - 자료구분 : 기본 값으로 NORMAL로 설정
     */
    private DataType dataType = DataType.NORMAL;

    /**
     * 정적(static) 초기화 구간
     */
    static {
        System.out.println("ProductVo - 정적 초기화 구간 실행");
        System.out.println("ProductVo - count = " + count);
    }

    /**
     * 초기화 블록
     */ {
        /**
         * 객체생성 시 마다 호출이 일어나며, count의 값을 1씩 증가 시킴
         */
        count++;
        System.out.println("ProductVo - 초기화 구간 실행 count[" + count + "]");

        /**
         * count를 이용하여 객체 품목번호를 정의함
         */
        if (count < 10) {
            productNo = MessageFormat.format("a00{0}", count);
        } else if (count < 100) {
            productNo = MessageFormat.format("a0{0}", count);
        } else {
            productNo = MessageFormat.format("a{0}", count);
        }
    }

    /**
     * 생성자함수 1
     */
    public ProductVo() {
        System.out.println("ProductVo - 생성자함수[1] 실행");
    }

    /**
     * 생성자함수 2
     */
    public ProductVo(String productName, int price) {
        this.productName = productName;
        this.price = price;
        System.out.println("ProductVo - 생성자함수[2] 실행");
    }

    /**
     * getter, setter 함수
     */
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * toString 함수
     */
    public String toString() {
        return MessageFormat.format("{0}\t{1}\t{2}", productNo, productName, price);
    }

    /**
     * ProductVo 항목을 String[]로 나타내기 위한 함수
     */
    public String[] getData() {
        return new String[]{
                productNo, productName, String.valueOf(price)
        };
    }

    /**
     * 내부 클래스(Inner Class) - 테이블 항목 정보
     */
    public static class TableInfo {
        public static final String[] HEADER_NAME_INFO
                = new String[]{"품목번호", "품목명", "단가", "상태"};
        // final static의 제한자는 바꾸어서 선언해도 상관없다.
        public final static int[] WIDTH_INFO = {100, 400, 100, 80};
    }
}
