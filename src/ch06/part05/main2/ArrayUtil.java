package ch06.part05.main2;

public class ArrayUtil {

    /**
     * ArrayUtl 클래스에서 3개의 함수 정의
     * 1. 마지막 자료 추가 함수
     * 2. 자료 중간 삽입 함수
     * 3. 자료 삭제 함수
     * 배열 추가 및 삭제 함수는 int 타입의 배열을 처리하는 함수로 제한하도록 한다
     */

    /**
     * @param array : 배열
     * @param value : 추가할 값
     * @return int[]
     * @author 이선우
     * @summary 배열(array)의 마지막 자료(value)를 추가하기 위한 함수
     * @summary 배열(array)의 마지막 자료(value)를 추가하기 위한 함수
     * @since 2022.02.26
     */
    public static int[] add(int[] array, int value) {
        int[] array2 = new int[array.length + 1];
        // array.length만큼 array2에 array 복사를 수행한다
        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array2.length - 1] = value; // 마지막 array에 value 값을 삽입한다
        return array2;
    }

    /**
     * @param array : 배열
     * @param index : 인덱스
     * @param value : 추가할 값
     * @return int[]
     * @author 이선우
     * @summary 배열 (array)의 인덱스(index)에 자료(value)를 중간 삽입하기 위한 함수
     * @since 2022.02.26
     */
    public static int[] add(int[] array, int index, int value) {
        int[] array2 = new int[array.length + 1];
        int row = 0; // 복사할 array의 인덱스
        for (int i = 0; i < array2.length; i++) {
            if (index == i) {
                array2[i] = value;
            } else {
                array2[i] = array[row++]; // array의 인덱스 row를 증가 시키면서 복사
            }
        }
        return array2;
    }

    public static int[] remove(int[] array, int index) {
        int[] array2 = new int[array.length - 1];
        int row = 0; // 복사할 array의 인덱스
        for (int i = 0; i < array.length; i++) {
            if (index != i) {
                array2[row++] = array[i]; // array의 인덱스 row를 증가 시키면서 복사한다
            }
        }
        return array2;
    }
}
