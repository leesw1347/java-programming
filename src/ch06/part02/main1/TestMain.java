package ch06.part02.main1;

import java.text.MessageFormat;

public class TestMain {

    /**
     * @param args 가변인자값
     * @return True, False
     * @summary 인자로 들어온 args가 Object 타입인지 아닌지를 분석하고 isnull인지 아닌지를 분류해준다
     * @since 2022.02.25
     */
    public static boolean isObject(Object ... args) {
        boolean ret = false;
        System.out.println(args);
        for(Object arg : args){
            if (arg instanceof String)
                ret = true;
        }
        return ret;
    }

    public static void main(String[] args) {
        /**
         * 배열 생성 및 사용 방법[1]
         */
        String[] array1 = new String[]{"자료1", "자료2", "자료3", "자료4", "자료5"};
        String data11 = array1[0]; /** 배열 내부 첫 번째 요소에 접근 */
        String data12 = array1[1];/** 배열 내부 두 번째 요소에 접근 */
        String data13 = array1[2];/** 배열 내부 세 번째 요소에 접근 */
        String data14 = array1[3];/** 배열 내부 네 번째 요소에 접근 */
        String data15 = array1[4];/** 배열 내부 다섯번째 요소에 접근 */
        int length1 = array1.length; /** 배열의 길이 */
        System.out.println(MessageFormat.format("length의 길이는 아래와 같습니다 {0}", length1));

        /**
         * 반복문을 이용한 배열 내부 요소 접근
         */
        if (array1 != null) {
            for (int i = 0; i < array1.length; i++) {
                System.out.println(MessageFormat.format("{0}번째 배열 값 = {1}", i, array1[i]));
            }
        }

        /**
         * 배열 객체를 생성하는 두 번째 식
         * 객체 생성 시 new String[] 의 생략이 가능하다
         */
        String[] array2 = {"자료1", "자료2", "자료3"};

        /**
         * String 타입의 기본값을 5개 담은 배열 객체를 의미한다
         * String 타입의 참조형이며, 참조형의 기본값은 'null' 입니다
         */
        String[] array3 = new String[5];
        array3[0] = "자료1";
        System.out.println(MessageFormat.format("array3의 1번째 인덱스 자료 {0}", array3[0]));
    }
}
