package ch03.part07.main1;

import java.util.Objects;

public class ProductVo2 {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductVo2)) return false;
        ProductVo2 that = (ProductVo2) o;
        return price == that.price && type == that.type && Objects.equals(productNo, that.productNo) && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, productName, price, type);
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    /**
     * 전역변수 - 타입의 속성
     */
    public String productNo; /* public - 모두 허용 */
    protected String productName; /* protected - 동일패키지, 상속 */
    private int price; /* private - 동일클래스 */
    int type; /* default 접근 - 동일패키지 */
}
