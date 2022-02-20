package ch03.part07.main1;

import ch03.part07.main1.vo.ProductVo1;

public class TestMain {
    public static void main(String[] args) {
        /**
         * ProductVo1 타입의 객체 생성
         * ProductVo1의 경우 vo 패키지에 존재하기 때문에 이 패키지에서는 public만 접근이 가능하다
         */
//        ProductVo1 prod1  = new ProductVo1();
//        prod1.productNo = "a001";
//        prod1.productName = "아메리카노";
//        prod1.price = 4000;
//        prod1.type = 1;

        /**
         * ProductVo2 타입의 객체 생성
         * ProductVo2의 패키지가 같기 때문에, public, protected, (default)에서 접근이 가능하다
         */
        ProductVo2 prod2 = new ProductVo2();
        prod2.productNo = "a001";
        prod2.productName = "아메리카노";
//        prod2.price = 4000; (오류발생)
        prod2.type = 1;
    }
}
