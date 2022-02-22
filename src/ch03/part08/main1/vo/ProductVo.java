package ch03.part08.main1.vo;

public class ProductVo {
    /**
     * static 을 이용한 화면에 나타낼 때 보일 항목명
     */
    public static String productNoKor = "품목번호";
    public static String productNameKor = "품목명";
    public static String priceKor = "단가";

    /**
     * 전역변수 - 일반적으로 private 처리
     */
    private String productNo;
    private String productName;
    private int price;
    private int type;

    /**
     * getter 함수, 외부에 전역변수 값을 반환
     */
    public String getProductNo() {
        return productNo;
    }

    public String getProductName(String productName) {
        return productName;
    }

    public int getPrice(int price) {
        return price;
    }

    /**
     * setter 함수 - 외부에서 전역변수 값을 설정
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}