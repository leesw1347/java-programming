package ch09.part01.main1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * toString()에 나타낼 속성명을 정의하기 위한 @Desc 어노테이션 정의
 */
@Retention(RetentionPolicy.RUNTIME) // 메모리에 로딩이 된 이후에도 지속하여 어노테션을 사용하겠다는 뜻
@Target(ElementType.FIELD) // 해당 어노테이션을 전역변수에서만 사용하겠다는 뜻
public @interface Desc {
    /**
     * name() 정의
     */
    public String name(); // @Desc(name="속성명")을 사용할 수 있도록 어노테이션 타입 정의
}