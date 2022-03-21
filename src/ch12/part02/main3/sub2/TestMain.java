package ch12.part02.main3.sub2;

import java.lang.reflect.Member;
import java.sql.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        // 자료구조 객체생성
        ArrayList<MemberVo> list1 = new ArrayList<>();

        // MemberVo 객체생성
        MemberVo member1 = new MemberVo("a001", "홍길동");
        MemberVo member2 = new MemberVo("a002", "이순신");

        // 자료추가
        list1.add(member1);
        list1.add(member2);
        System.out.println("[최초 자료등록]");
        System.out.println(MessageFormat.format("\t[list1] {0}", list1));

        // 자료복사 - Deep Copy
        ArrayList<MemberVo> list2 = (ArrayList<MemberVo>) list1.clone();
        System.out.println("[자료복사 DeepCopy]");
        System.out.println(MessageFormat.format("\t[list2] {0}", list2));

        // 자료 member1 속성변경
        member1.memberId = "p001";
        System.out.println("[member1 속성변경]");
        System.out.println(MessageFormat.format("\t[list1] {0}", list1));
        System.out.println(MessageFormat.format("\t[list2] {0}", list2));

        // 자료의 추가
        MemberVo member3 = new MemberVo("a003", "강감찬");
        list1.add(member3);
        System.out.println("[member3 객체 자료등록]");
        System.out.println("\t[list1] " + list1);
        System.out.println("\t[list2] " + list2);

        // 추가로 Deep Copy 내용 추가
        ArrayList list1_array = new ArrayList();
        list1_array.add("a");
        list1_array.add("b");
        list1_array.add("c");
        list1_array.add("d");

        ArrayList list2_array = new ArrayList();

        ArrayList list1_clone_array = (ArrayList) list1_array.clone(); // 자료복사1
        for (Object o : list1_array) { // 자료복사2
            list2_array.add(o);
        }
        ArrayList list3_array = new ArrayList(list1); // 자료복사3
        List list4_array = new ArrayList<>();
        list4_array.addAll(list2);
    }

    // MemberVo 내부클래스 정의
    // MemberVo 클래스를 static으로 설정한 이유는
    // 정적함수에서는 static 전역변수 또는 static 함수 외에는 접근이 되지 않기 때문에,
    // static 클래스를 정의하여 사용하면 된다.
    public static class MemberVo {
        // 생성자함수 정의
        public MemberVo(String memberId, String memberName) {
            this.memberId = memberId;
            this.memberName = memberName;
        }

        // memberId, memberName 전역변수 정의
        private String memberId = null;
        private String memberName = null;

        @Override
        public String toString() {
            return MessageFormat.format("[{0}.{1}]", memberId, memberName);
        }
    }
}