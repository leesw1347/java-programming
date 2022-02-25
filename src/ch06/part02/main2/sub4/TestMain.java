package ch06.part02.main2.sub4;

public class TestMain {
    /**
     * 메인함수 정의
     * 배열로 나타내기
     * 반복문을 이용하여 조회하기
     */
    public static void main(String[] args) {
        /**
         * 배열로 나타내기
         */
        String[][] array = {
                new String[]{"a001", "김철수", "010-1111-1111"},
                new String[]{"a002", "이영희", "010-2222-2222"},
                new String[]{"a003", "박남수", "010-3333-3333"}
        };

        /**
         * for문으로 조회하기
         */
        /**
        System.out.println("for문으로 조회하기");
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                String data = array[i][j];
                System.out.println("조회되는 자료 " + data.toString());
            }
        }
         */

        /**
         * 향상된 for문으로 조회
         */
        System.out.println("향상된 for문으로 조회하기");
        for (String[] arr1 : array) {
            System.out.println();
            for (String data : arr1) {
                System.out.println("조회되는 자료 " + data.toString());
            }
        }
    }
}
