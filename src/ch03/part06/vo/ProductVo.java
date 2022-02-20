package ch03.part06.vo;

import java.text.MessageFormat;

public class ProductVo {

    public String productNo;
    public String productName;
    public int price;
    public String setProductNo;
    public String setProductName;

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String getProductNo(){
        return this.productNo;
    }

    /**
     * 외부에서 품목번호, 품목명을 입력 시 전역변수에 저장하기 위한 변수
     */
    public int setProductInfo(String productNo, String productName) {
        this.setProductNo = productNo;
        this.setProductName = productName;
        return 0;
    }

    /**
     * 외부에서 품목번호, 품목명, 단가를 입력 시 전역변수에 저장하기 위한 함수
     */
    public int setProductInfo(String productNo, String productName, int price) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
        return 0;
    }

    /**
     * 각 제품별로 상세정보를 출력한다
     */
    public void printProductInfo(){
        System.out.println(MessageFormat.format("제품명은 {0}", this.getProductName()));
        System.out.println(MessageFormat.format("제품번호는 {0}", this.getPrice()));
    }

}
