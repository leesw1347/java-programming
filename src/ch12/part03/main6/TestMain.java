package ch12.part03.main6;


import java.util.HashSet;
import java.util.Set;

/**
 * 기본형의 자료는 Wrapper 클래스 타입의 참조형으로 자동 변환
 * List의 개념과 동일하기 때문에 생략한다
 */
public class TestMain {
    /**
     * 자료삭제
     * Set은 '인덱스'의 값이 존재하지 않기 때문에 '인덱스' 삭제는 되지 않는다
     * 자료의 삭제는 '자료 객체'로 자료 삭제가 가능하다
     * Set<Integer> 타입의 객체는 int 타입의 값으로 자료 삭제 시 Integer 타입으로 형변환하여 자료가 있을 경우 삭제한다
     * 이런 경우를 Auto Boxing (오토박싱) 이라고 한다
     */
    public static void main(String[] args) {
        // Set 타입 객체생성 및 자료등록
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(new Integer(10));
        set.add(new Integer(100));
        System.out.println("set 객체생성 및 자료등록");
        System.out.println(set);
        System.out.println();

        // 자료삭제 1
        set.remove(10);
        System.out.println("자료삭제 : 10");
        System.out.println(set);
        System.out.println();

        // 자료삭제 2
        set.remove(new Integer(100));
        System.out.println("자료삭제 : new Integer(100)");
        System.out.println();
    }
}
