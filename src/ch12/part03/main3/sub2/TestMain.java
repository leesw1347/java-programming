package ch12.part03.main3.sub2;

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
        System.out.println("\t[list2] " + list2);

        // 자료복사 - Deep Copy의 다른 방법들
        list2 = (ArrayList<MemberVo>) list1.clone(); // method1
        list2 = new ArrayList<>();  // method2
        for (Object o : list1) {
            list2.add((MemberVo) o);
        }
        list2 = new ArrayList<>(list1); // method3
        list2.addAll(list1); // method4

        // 자료 member1 속성변경
        member1.memberId = "p001"; // 여기서 list1에는 member1, member2에 대한 메모리 주소가 들어가 있으므로,
        // member1을 변경하면 list1, list2에 있는 member 객체들의 값은 변경된다
        System.out.println("[member1 속성변경]");
        System.out.println(MessageFormat.format("\t[list1] {0}", list1));
        System.out.println(MessageFormat.format("\t[list2] {0}", list2));

        // 자료의 추가
        MemberVo member3 = new MemberVo("a003", "강감찬");
        list1.add(member3); // list1, list2는 서로 다른 객체이기 때문에 보유하고 있는 Member가 다르다
        System.out.println("[member3 객체 자료등록]");
        System.out.println(MessageFormat.format("\t[list1] {0}", list1));
        System.out.println(MessageFormat.format("\t[list2] {0}", list2));
    }

    // MemberVo 내부 클래스 정의
    public static class MemberVo {
        // 생성자함수 정의
        public MemberVo(String memberId, String memberName) {
            this.memberId = memberId;
            this.memberName = memberName;
        }

        private String memberId;
        private String memberName;

        @Override
        public String toString() {
//            return super.toString();
            return "[" + memberId + "." + memberName + "]";
        }
    }
}
