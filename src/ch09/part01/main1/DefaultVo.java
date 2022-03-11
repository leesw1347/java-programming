package ch09.part01.main1;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public class DefaultVo {
    @Override // 부모 클래스가 가지고 있는 함수를 '재정의' 하겠다는 뜻
    public String toString() {
        /**
         * 문자열의 자료 저장을 위한 StringBuffer 클래스 객체 생성
         */
        StringBuffer sb = new StringBuffer();

        /**
         * 문자열에 Class 객체생성 및 클래스정보 저장
         */
        Class<? extends DefaultVo> clazz = this.getClass();
        sb.append(MessageFormat.format("{0} 정보", clazz.getName()));

        /**
         * Field 목록 객체생성
         * clazz에 존재하는 모든 전역변수의 필드명, 필드값, @Desc에 명시된 name 값으로 보여준다
         */
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            if (f != null) {
                /**
                 * 전역변수명 조회
                 */
                String name = f.getName();
                String desc = "";

                /**
                 * @Desc 어노테이션에 명시된 name() 값 조회 - 필드 항목명
                 */
                Desc anno = f.getDeclaredAnnotation(Desc.class);
                if (anno != null) {
                    desc = anno.name();
                }

                /**
                 * 전역변수의 값 조회
                 */
                String value = "";
                try {
                    /**
                     * 접근권한부여 -> 전역변수 값 조회 -> 접근권한복원
                     */
                    boolean accessible = f.isAccessible();
                    f.setAccessible(true);
                    Object obj = f.get(this); // 전역변수 값
                    if (obj != null) {
                        value = obj.toString();
                    }
                    f.setAccessible(accessible); // 접근권한 복원

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                /**
                 * 앞의 문자열에 name, value, desc의 정보를 갖는 문자열을 추가
                 */
                sb.append("\r\n\t" + name + " = " + value + " [ " + desc + " ] ");

            }
        }
        return sb.toString();
    }
}
