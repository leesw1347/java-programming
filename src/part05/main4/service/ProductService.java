package part05.main4.service;

import ch03.port05.main3.vo.ProductVo;

/**
 * 전체 품목에 대한 목록 조회, 품목 수정, 품목 삭제 등 시스템으로의 저장 및 조회를 위한
 * 로직을 처리하기 위한 서비스 클래스임
 * MVC 패턴의 모델에 해당하는 부분으로 서비스 처리를 위한 단위 업무를 해결하기 위한 기능을 관리하는 클래스임
 * <p>
 * 서비스 클래스의 기능 활용 예
 * 1. 전체목록 조회
 * 2. 특정 품목의 상세 정보 조회
 * 3. 특정 품목의 수정, 삭제
 */
public class ProductService {
    /**
     * 1. 품목번호를 제공하면 해당 품목정보를 반환하는 함수
     */
    public ProductVo getProduct(String productNo) {
        /**
         * 품목정보를 조회하기 위한 로직 생략
         */
        ProductVo productVo = null;
        return productVo;
    }

    /**
     * 품목정보를 제공하면 해당 품목을 데이터베이스에 수정 후 수정된 데이터의 수를 반환하는 함수
     */
    public int updateProduct(ProductVo productVo) {
        /**
         * 품목정보를 저장하기 위한 로직 생략
         */
        int updateProduct = 0; // 로직생략 - 임의로 0으로 처리함
        return updateProduct;
    }

    /**
     * 품목정보를 제공하면 해당 품목을 데이터베이스에 등록 후 성공여부를 반환하는 함수
     */
    public boolean insertProduct(ProductVo productVo) {
        /**
         * 품목정보를 신규 등록하기 위한 로직 생략
         */
        boolean insertProduct = false; // 로직생략 - 임의로 false
        return insertProduct;
    }

    /**
     * 품목번호를 제공하면 해당 품목 정보를 삭제하기 위한 함수
     */
    public void deleteProduct(String productNo) {
        /**
         * 품목을 삭제하기 위한 로직 생략
         */
    }
}