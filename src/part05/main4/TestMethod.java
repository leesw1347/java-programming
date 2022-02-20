package part05.main4;

import ch03.port05.main3.vo.ProductVo;
import part05.main4.service.ProductService;

public class TestMethod {
    public static void main(String[] args) {
        /**
         * 1. 다음 3개의 품목의 정보를 ProductVo로 만든 후 신규 등록하세요
         */
        // 1) product1 객체생성 및 속성설정
        ProductVo product1 = new ProductVo();
        product1.setProductNo("a001");
        product1.setPrice(4000);

        /**
         * ProductService 함수를 사용하기 위한 서비스 객체설정
          */
        ProductService service = new ProductService();

        // 4) 데이터베이스 시스템에 자료 등록
        service.insertProduct(product1);

        /**
         * 아메리카노 품목의 단가를 200원 인상 후 자료를 저장하시오
         */
        int price = product1.getPrice() + 200;
        product1.setPrice(price);
        int updateProduct = service.updateProduct(product1);

        /**
         * 카페모카 품목을 삭제하세요
         */
        service.deleteProduct("a003");
    }
}
