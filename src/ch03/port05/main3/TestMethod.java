package ch03.port05.main3;

import ch03.port05.main3.vo.ProductVo;

import java.text.MessageFormat;

public class TestMethod {

    public static void main(String[] args) {
        /**
         * ProductVo 객체 생성
         */
        ProductVo v = new ProductVo();

        /**
         * ProductVo 함수 사용
         */
        v.setProductNo("a001");
        v.setProductName("아메리카노");
        v.setPrice(4000);

        System.out.println(MessageFormat.format("productNo = {0}", v.getProductNo()));
        System.out.println(MessageFormat.format("productName = {0}", v.getProductName()));
        System.out.println(MessageFormat.format("price = {0}", v.getPrice()));
    }
}