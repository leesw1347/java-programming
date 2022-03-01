package ch07.part06.main2.sub2;

import java.security.MessageDigest;
import java.text.MessageFormat;

/**
 * 1. Class 타입 객체 생성
 * 2. 생성자 함수 관리 클래스인 Constructor 객체의 호출 및 객체 생성
 * 3. 전역변수의 관리 클래스인 Field 객체의 호출 및 전역변수 값을 조회, 수정
 * 4. 함수의 관리 클래스인 Method 객체의 호출 및 함수 실행
 */
public class ProductVo {

    /**
     * 전역변수 정의
     */
    private String productName;
    private int price;

    /**
     * 생성자함수 정의
     */
    public ProductVo() {
    }

    public ProductVo(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    /**
     * getter, setter 함수 정의
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return MessageFormat.format("return productName {0}", price);
    }
}
