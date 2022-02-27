package ch07.main1.part05.main1;

/**
 * 제네릭 타입이 T인 클래스 정의
 * 타입 파라미터인 (T) 는 실제 클래스 타입이 아닌, 임의 타입으로 일반적으로 대문자로 된
 * 임의의 단일 문자를 타입으로 지정한다
 */
public class TypeA<T> {
    /**
     * 제네릭 타입을 타입으로 하는 속성 정의
     * 제네릭 타입을 이용한 생성자 함수 정의
     * 반환 타입이 제네릭 타입 (T 타입) 인 getter 함수 정의
     */

    /**
     * 제네릭 타입을 타입으로 하는 속성 정의
     */
    private T t;

    /**
     * 제네릭 타입을 이용한 생성자 함수 정의
     */
    public TypeA(T t){
        this.t = t;
    }

    /**
     * 반환타입이 제네릭 타입(T 타입)인 getter 함수 정의
     */
    public T getT(){
        return t;
    }
}