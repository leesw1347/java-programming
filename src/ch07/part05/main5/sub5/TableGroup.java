package ch07.part05.main5.sub5;

import javax.swing.*;

/**
 * @param <T> DefaultVo 또는 DefaultVo의 하위 클래스로 사용할 때 적용할 수 있다
 */
public class TableGroup<T extends DefaultVo> {
    /**
     * 생성자 함수 정의
     * 헤더 정보와 자료 목록 정보를 가져와서 테이블에 처리
     * 테이블 구성
     */
    private JScrollPane pane = new JScrollPane();

    /**
     * @param array 동적 파라미터를 이용할 수 있도록 정의됨
     *              T 타입의 배열 또는 콤마를 이용하여 T 타입의 객체를 입력할 수 있다
     */
    @SafeVarargs
    public TableGroup(T... array) {
        /**
         * 헤더정보와 자료목록정보를 가져와서 테이블에 처리
         */
        String[] header = array[0].getHeaderInfo();
        Object[][] data = new Object[array.length][];

        for (int i = 0; i < data.length; i++) {
            T t = array[i];
            data[i] = t.getData();
        }
        /**
         * 테이블 구성
         */
        JTable table = new JTable(data, header);
        pane.setViewportView(table);
    }

    public JScrollPane getTablePanel() {
        return pane;
    }
}