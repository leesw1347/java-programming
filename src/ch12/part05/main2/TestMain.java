package ch12.part05.main2;

import java.util.Stack;

public class TestMain {
    public static void main(String[] args) {
        // 객체생성
        Stack<Integer> stack = new Stack<>();

        // stack에 자료존재 여부 검사
        System.out.println(stack.isEmpty());

        // 자료추가 push() -> 1,2,3,4
        Integer push1 = stack.push(1);
        System.out.println(
                "절차1\tpush():" + push1 + "\tpeek():" + stack.peek() + "\tstack:" + stack
        );

        Integer push2 = stack.push(2);
        System.out.println(
                "절차2\tpush():" + push2 + "\tpeek():" + stack.peek() + "\tstack:" + stack
        );

        Integer push3 = stack.push(3);
        System.out.println(
                "절차3\tpush():" + push3 + "\tpeek():" + stack.peek() + "\tstack:" + stack
        );

        Integer push4 = stack.push(4);
        System.out.println(
                "절차4\tpush():" + push4 + "\tpeek():" + stack.peek() + "\tstack:" + stack
        );

        // 마지막자료 삭제
        Integer pop1 = stack.pop();
        System.out.println(
                "절차6\t pop():" + pop1 + "\tpeek():" + stack.peek() + "\tstack:" + stack
        );

        Integer pop2 = stack.pop();
        System.out.println(
                "절차7\t pop():" + pop2 + "\tpeek():" + stack.peek() + "\tstack:" + stack
        );

        Integer pop3 = stack.pop();
        System.out.println(
                "절차8\t pop():" + pop3 + "\tpeek():" + stack.peek() + "\tstack:" + stack
        );

        // EmptyStackException 에러 발생
        // Stack 자료 구조에 자료가 없을 떄 peek(), pop() 함수를 호출 시 에러를 발생 시킨다
        // 필요하다면 peek(), pop() 함수를 호출하기 전 isEmpty() 함수를 호출해서 자료 존재여부를 확인하는 작업을 거쳐야 한다

        // stack에 자료존재여부 검사
        System.out.println(stack.isEmpty());
    }
}
