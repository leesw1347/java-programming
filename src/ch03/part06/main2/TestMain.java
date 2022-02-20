package ch03.part06.main2;

import ch03.part06.vo.ProductVo;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 품목 객체생성
         */
        ProductVo product1 = new ProductVo();
        product1.setProductNo("a001");
        product1.setProductName("아메리카노");
        product1.setPrice(4000);

        /**
         * setProductInfo() 함수 사용
         */
        ProductVo product2 = new ProductVo();
        product2.setProductInfo("a002", "카페라떼");
        product2.setPrice(4300);

        /**
         * setProductInfo() 함수 사용
         */
        ProductVo product3 = new ProductVo();
        product3.setProductInfo("a003", "카페모카", 4500);

        product1.printProductInfo();
        product2.printProductInfo();
        product3.printProductInfo();

    }
}
