package ch11.part03.main3;

public class StringUtil {
    // equalsOr() 공통처리함수 정의
    // ... 연산자 -> String 타입 파라미터를 '0'개 이상 동적으로 사용 가능하게 함
    // 내부에서는 compare 변수는 String[] 타입이 된다
    public static boolean equalsOr(String target, String... compare) {
        boolean ret = false;

        // nullpointer exception 처리
        if (target == null || compare == null) {
            ret = false;
        } else {
            for (String s : compare) {
                if (target.equals(s)) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }
}