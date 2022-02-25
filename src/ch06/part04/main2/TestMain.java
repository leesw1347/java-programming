package ch06.part04.main2;

public class TestMain {
    /**
     * 메인함수 정의
     * 복사할 대상 배열
     * 복사될 대상 배열
     * System.arraycopy() 함수 실행
     */
    public static void main(String[] args) {
        /**
         * 복사할 대상 배열
         */
        int[] array1 = new int[]{11, 12, 13, 14, 15};

        /**
         * 복사될 대상 배열
         */
        int[] array2 = new int[]{21, 22, 23, 24, 25};

        /**
         * array1 배열의 인덱스 (1)부터 시작해서 array2 배열의 인덱스 0으로 길이 3만큼 복사하겠다는 명령
         */
        System.arraycopy(array1, 1, array2, 0, 3);

        for (int i = 0; i < array2.length; i++) {
            System.out.println("array[" + i + "] = " + array2[i]);
        }
    }
}
