package ch03.part04.main01;

import ch03.part04.main01.vo.ProductVo;

import java.text.MessageFormat;

public class TestReference1 {
    public static void main(String[] args) {
        /**
         * 참조형 변수의 생성
         */
        ProductVo product1 = new ProductVo();
        ProductVo product2 = new ProductVo();
        ProductVo product3 = new ProductVo();

        /**
         * Product1의 속성 정보 입력
         */
        product1.productNo = "a001";
        product1.producetName = "아메리카노";
        product1.price = 4000;

        System.out.println("product1의 정보");
        System.out.println("품목번호[" + product1.productNo + "]");
        System.out.println("품목명[" + product1.producetName + "]");
        System.out.println("단가[" + product1.price + "]");

        /**
         * 객체 비교 A - 같은 객체인지 비교하기
         */
        boolean compare1 = (product1 == product2);

        /**
         * 객체 메모리 주소 정보를 복사하기
         */
        ProductVo prod1 = product1;
        ProductVo prod2 = product2;
        ProductVo prod3 = product3;

        /**
         * 객체 비교 B - 같은 객체인지 비교하기
         */
        boolean compare3 = (prod1 == product1);

        String result = MessageFormat.format("prod1 == product1 : {0}", compare3);
        System.out.println(result);

        /**
         * 타입 비교
         */
        boolean typeCompare1 = (product1 instanceof ProductVo);
        MessageFormat.format("product instanceof ProductVO : {0},", typeCompare1);
        System.out.println("product1 instanceof ProductVO : " + typeCompare1);
    }
}