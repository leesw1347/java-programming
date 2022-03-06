package ch08.part02.main4.sub2;


/**
 * String 클래스와, StringBuffer 클래스의 비교 - 문자열 이어쓰기
 */
public class TestMain {
    public static void method(String str){
        // 파라미터의 문자열에 이어서 쓰기작업을 한다
        str += " 문자열 추가";
    }

    public static void method(StringBuffer sb){
        /**
         * StringBuffer의 내부의 문자열에 이어서 쓰기 작업을 한다
         */
        sb.append(" 문자열 추가");
    }

    public static void main(String[] args) {
        // String, StringBuffer 변수의 생성
        String str = "메인 str";
        StringBuffer sb = new StringBuffer("메인 sb");
        System.out.println("String 초기 값 = " + str);
        System.out.println("StringBuffer 초기 값 = " + sb.toString());

        // static 함수사용 - 파라미터로 각각의 변수전달
        method(str);
        method(sb);

        System.out.println("String 변경 값 = " + str);
        System.out.println("StringBuffer 변경 값 = " + sb.toString());
    }
}