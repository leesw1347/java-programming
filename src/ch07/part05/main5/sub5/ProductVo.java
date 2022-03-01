package ch07.part05.main5.sub5;

/**
 * 품목정보를 나타내는 클래스
 * DefaultVo 클래스 상속
 */
public class ProductVo extends DefaultVo {
    /**
     * getHeaderInfo()를 none-static 함수로 처리
     */

    /**
     * 속성 정의
     */
    private String productNo;
    private String productName;
    private int price;

    /**
     * 생성자함수 정의
     */
    public ProductVo(String productNo, String productName, int price) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
    }

    /**
     * 자료의 정보를 반환하는 함수 정의
     */
    @Override
    public Object[] getData() {
        return new Object[]{
                productNo, productName, price
        };
    }

    /**
     * 테이블의 헤더정보를 반환하는 함수 정의
     */
    @Override
    public String[] getHeaderInfo() {
        return new String[]{
                "품목번호", "품목명", "단가"
        };
    }
}
