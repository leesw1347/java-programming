package ch03.part08.main1;

import ch03.part08.main1.vo.ProductVo;

public class TestMain {
    public static void main(String[] args) {
        /**
         * 접근 가능한 static 변수의 호출
         */
        String productNoKor = ProductVo.productNoKor;
        String productNameKor = ProductVo.productNameKor;
        String prictKor = ProductVo.priceKor;

        /**
         * 접근 가능한 static 변수를 객체1에서 호출
         */
        ProductVo product1 = new ProductVo();
        String productNoKor1 = product1.productNoKor;
        String productNameKor1 = product1.productNameKor;
        String priceKor1 = product1.priceKor;

        /**
         * 접근 가능한 static 변수를 객체2에서 호출
         */
        ProductVo product2 = new ProductVo();
        String productNoKor2 = product2.productNoKor;
        String productNameKor2 = product2.productNameKor;
        String priceKor2 = product2.priceKor;

        /**
         * static 변수를 변경
         */
        product1.productNameKor = "제품명";
        System.out.println(product1.productNameKor);
    }

    /**
     * @param title
     * @param value
     * @return null
     * @summary 외부에서 제목과 값을 부여 시 해당 값을 콘솔화면에 나타내기 위한 함수
     */
    private static void print(String title, String value) {
        System.out.println(title + "\t" + value); // "\t"는 탭 간격을 나타내는 특수문자이다
    }
}