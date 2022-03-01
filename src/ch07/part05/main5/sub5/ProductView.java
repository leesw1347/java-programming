package ch07.part05.main5.sub5;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

/**
 * 제품 정보 목록을 화면 구성 및 실행을 위한 클래스
 * 모듈을 이용하여 테이블 정보 만들기
 */
public class ProductView extends JFrame {
    /**
     * 테이블 자료 및 컴포넌트 구성을 TableGroup으로 처리
     */

    public ProductView() throws HeadlessException {
        /**
         * 화면 사이즈 설정
         */
        this.setSize(300, 300);

        /**
         * 테이블 자료
         */
        ProductVo product1 = new ProductVo("a001", "아메리카노", 4000);
        ProductVo product2 = new ProductVo("a002", "까페라떼", 4300);
        ProductVo product3 = new ProductVo("a003", "까페모카", 4500);

        /**
         * 모듈을 이용하여 테이블 정보 만들기
         */
        TableGroup<ProductVo> tableGroup =
                new TableGroup<ProductVo>((Class)this.getClass(), product1, product2, product3);

        System.out.println(MessageFormat.format("tableGroup 정보는 {0}", tableGroup));

        /**
         * 화면에 추가하기
         */
        this.add(tableGroup.getTablePanel());
    }

    public static void main(String[] args) {
        ProductView view = new ProductView();
        view.setVisible(true);
    }
}