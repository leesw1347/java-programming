package ch15.part03.main7.sub1;

import java.io.Serializable;

public class ProductVo implements Serializable { // 직렬화
    private String productNo;
    private String productName;
    private int price;

    public ProductVo() {

    }

    public ProductVo(String productNo, String productName, int price) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductNo() {
        return this.productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "ProductVo[productNo=" + productNo + ". productName=" +
                productName + ". price=" + price + "]";
    }
}