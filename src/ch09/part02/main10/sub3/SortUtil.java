package ch09.part02.main10.sub3;

import java.text.MessageFormat;
import java.util.List;

public class SortUtil {

    /**
     * 객체 값 정렬을 위한 함수 정의
     */


    /**
     * @summary  제네릭스를 이용한 타입의 동적처리
     실제 사용할 타입을 입력하도록 제네릭스를 정의함
     * @param list: 제네릭스 오브젝트
     * @param comparator: 인터페이스를 이용한 로직의 분리
     * @param <T>
     * @return Integer
     */
    public static <T> void sort(List<T> list, Comparator<T> comparator) {

        // 정렬을 위해선 최소 2개 이상의 값이 리스트에 존재해야 한다
        if (list == null || list.size() <= 1) {
            return;
        }

        boolean isChanged = false;
        while (true) {
            isChanged = false;
            System.out.println(MessageFormat.format("변경된 여부를 확인 {0}", isChanged));
            for (int i = 0; i < list.size() - 1; i++) {
                // 순차적으로 list에 임의 자료와 그 다음 인덱스의 자료를 조회
                T p1 = list.get(i);
                T p2 = list.get(i + 1);

                // 두 값을 비교하기 위한 로직 구성
                int result = comparator.compare(p1, p2);

                // 앞의 값이 클 경우만 자리이동
                if (result > 0) {
                    list.set(i, p2);
                    list.set(i + 1, p1);
                    isChanged = true;
                }
            }
            // 자리 바꿈이 일어나지 않을 경우 루프를 벗어난다
            if(!isChanged){
                break;
            }
        }
    }

    // 자료정렬 로직처리를 위한 인터페이스 정의
    public interface Comparator<T> {
        // 자료정렬 로직처리를 위한 compare() 추상메소드 정의
        public int compare(T t1, T t2);
    }
}
