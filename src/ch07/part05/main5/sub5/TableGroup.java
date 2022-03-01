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
     * @change 2022.03.01 리플렉션으로 객체생성을 위해 Class<T> 타입 파라미터 추가
     */
    @SafeVarargs
    public TableGroup(Class<T> clazz, T... array) {
        /**
         * 헤더정보와 자료목록정보를 가져와서 테이블에 처리
         */

        /**
         * null을 고려하여 자료목록정보 구성
         */
        Object[][] data = null;
        if (array == null) { // null일 경우의 처리
            data = new Object[0][];
        } else { // null이 아닐 경우 처리
            data = new Object[array.length][];
            for (int i = 0; i < data.length; i++) {
                T t = array[i];
                data[i] = t.getData();
            }
        }

        /**
         * null과 배열의 길이를 고려하여 헤더정보 구성
         */
        String[] header = null;
        if(array == null || array.length == 0){
            /**
             * 리플렉션을 이용한 클래스 객체생성
             */
            try {
                // 이 부분이 리플렉션 기능이며, Class 타입의 객체를 이용하여 동적으로 객체 생성을 하였다.
                T t = clazz.newInstance();
                header = t.getHeaderInfo();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else{
            header = array[0].getHeaderInfo();
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