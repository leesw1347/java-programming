package ch09.part01.main1;

/**
 * ProductVo 클래스는 DefaultVo 클래스를 상속 받는다
 * DefaultVo 클래스의 필드 및 함수를 상속 받는다
 * 함수의 경우 재정의를 하면 해당 함수의 로직은 자식의 로직을 따른다(Override)
 */
public class ProductVo extends DefaultVo { // DefaultVo 클래스를 상속
    /**
     * 전역변수 정의
     */
    @Desc(name = "품목번호")
    private String productNo;

    @Desc(name = "품목명")
    private String productName;

    @Desc(name = "단가")
    private int price;

    /**
     * getter, setter 함수 정의
     */
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
