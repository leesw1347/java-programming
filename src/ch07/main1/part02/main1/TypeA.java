package ch07.main1.part02.main1;
import java.text.MessageFormat;

public class TypeA {
    /**
     * 정적(static) 전역변수 정의
     * 전역변수 정의
     * 정적(static) 초기화 블록 정의
     * 초기화 블록 정의
     * 생성자 함수 정의 1
     * 생성자 함수 2
     */

    /**
     * 정적(static) 전역변수
     */
    private static String var1 = "var1";

    /**
     * 전역변수
     */
    private String var2 = "var2";

    /**
     * 정적(static) 초기화 블록
     */
    static {
        System.out.println("\t정적 초기화블록 : var1[" + var1 + "]");
    }

    /**
     * 초기화블록
     */ {
        System.out.println("\t초기화블록 : var1[" + var1 + "], var2[" + var2 + "]");
    }

    /**
     * 생성자함수 1
     */
    public TypeA() {
        String msg = MessageFormat.format("var1[{0}], var2[{1}]", var1, var2);
        System.out.println(msg);
    }

    /**
     * 생성자함수 2
     */
    public TypeA(String param) {
        String msg = MessageFormat.format("\t생성자함수2 : var1[{0}], var[{1}], param[{2}]", var1, var2, param);
        System.out.println(msg);
    }
}
