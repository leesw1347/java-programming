package ch12.part05.main3.sub3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue를 이용한 자료 저장 및 자료 삭제 [2]
 * 자료 순서는 저장과 삭제 시 우선 순위를 고려하여 저장되기 때문에, 순서대로 저장되지 않는다
 * Comparator에 의해 정렬된 순서대로 자료를 삭제한다
 */
public class TestMain {
    public static void main(String[] args) {
        // String 자료를 내림차순으로 자료정렬을 위한 익명클래스 정의
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int ret = -1;
                if (o1 == null && o2 != null) {
                    ret = -1;
                } else if (o1 != null && o2 == null) {
                    ret = 1;
                } else if (o1 == null && o2 == null) {
                    ret = 0;
                } else {
                    ret = o1.compareTo(o2);
                }
                System.out.println("ret1");
                System.out.println(ret);
                System.out.println("ret2");
                return ret;
            }
        };

        // 사용자 정렬 PriorityQueue 객체생성
        Queue<String> q = new PriorityQueue<>(comparator);

        // 자료추가
        offer(q, "1");
        offer(q, "e");
        offer(q, "b");
        offer(q, "3");
        offer(q, "c");

        // 자료삭제
        poll(q);
        poll(q);
        poll(q);
        poll(q);
        poll(q);
    }

    // 인쇄 라인 번호를 나타내기 위한 변수
    private static int no = 0;

    // 자료 저장 및 메세지 출력
    private static void offer(Queue q, Object data) {
        q.offer(data); // 저장
        no++;
        String msg = no + "\t offer [" + data + "]";
        msg += "\t peek [" + q.peek() + "]";
        msg += "\t 자료구조 " + q;
        System.out.println(msg);
    }

    private static void poll(Queue q) {
        Object data = q.poll();
        no++;
        String msg = no + "\t poll [" + data + "]";
        msg += "\t peek [ " + q.peek() + "]";
        msg += "\t 자료구조 " + q;
        System.out.println(msg);
    }
}
