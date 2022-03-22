package ch12.part02.main6;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    /**
     * 자료의 삭제
     * 자료의 삭제는 인덱스의 값으로 삭제가 가능하다
     * 자료의 삭제는 '자료 객체'로 첫 번째 자료 삭제가 가능하다
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);

        System.out.println(MessageFormat.format("[1] : {0}", list));
        // 인덱스 [1]의 자료를 삭제
        list.remove(1);

        System.out.println(MessageFormat.format("[2] : {0}", list));
        // 자료값 Integer 타입객체 삭제
//        list.remove(new Integer(2));
        System.out.println(MessageFormat.format("[3] : {0}", list));
    }
}
