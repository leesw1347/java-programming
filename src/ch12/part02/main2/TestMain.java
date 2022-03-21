package ch12.part02.main2;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    /*
    public boolean add(E 자료 객체)
        자료 등록(삽입)하며 성공할 경우 true를 반환
        가장 마지막 인덱스에 자료가 추가된다
        ex) list.add("a");

    public boolean add(int 인덱스, E 자료 객체)
        해당 인덱스에 자료 등록(중간 삽입)을 하며, 자료 등록이 성공할 경우 true를 반환
        삽입된 이후의 자료는 다음 인덱스 위치로 자료 이동이 발생한다

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add(0, "a");

     public E set(int index, E 자료 객체)
        해당 인덱스의 자료를 수정하며, 수정되기 전의 자료를 반환한다
        해당 인덱스의 자료가 수정된다

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.set(0, "c");

     public E remove(int 인덱스)
        해당 인덱스의 자료를 삭제하며, 삭제되는 자료를 반환한다
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.remove(0);

     public boolean remove(E 자료 객체)
        해당 자료를 삭제 후 자료 삭제가 될 경우 true를 반환한다
        해당 첫 번째 자료 객체를 삭제한다

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.remove("a");

     public void clear()
        자료 구조에 담겨 있는 모든 자료를 삭제한다
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.clear();

    public E get(int 인덱스)
        해당 인덱스의 자료를 반환한다
        - 제네릭스를 이용하는 경우 해당 타입을 반환한다
        - 제네릭스를 사용하지 않는 경우, Object 타입을 반환한다

    ex1)
        List<String> list = new ArrayList<String>();
        list.add('a');
        list.add('b');
        String data = list.get(0);

    ex2)
        List list = new ArrayList();
        list.add('a');
        list.add('b');
        Object data = list.get(0);

    public int size()
        자료 구조에 저장된 총 자료 수를 반환한다
        List<String> list = new ArrayList<String>();
        list.add("a");
        int size = list.size();

    public boolean contains(E 자료 객체)
        해당 자료 객체가 자료 구조에 포함되어 있는지 여부를 반환한다
        <사용 예>
            List<String> list = new ArrayList<String>();
            list.add("a");
            list.add("b");
            boolean contains = list.contains("a");

    public List<E> subList(int startIndex, int endIndex)
        startIndex: 시작 인덱스,
        endIndex: 종료 인덱스
        시작 인덱스 ~ 종료 인덱스 미만의 자료를 추출하여 해당 List 타입으로 반환한다

        <사용 예>
            List<String> list = new ArrayList<String>();
            list.add("a");
            list.add("c");
            List<String> subList = list.subList(0,1);

    public boolean addAll(Collection<? extends E> c)
        c : Collection 타입 객체로, Set 타입의 상위 인터페이스 타입 객체임
        List, Set 타입의 객체를 뜻함
        자료 구조에 Collection 타입 자료 객체를 일괄 등록한다

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list.addAll(list2);
     */

    public static void main(String[] args) {
        /**
         * 기본 생성자 함수를 이용한 객체 생성
         * '제네릭스'를 이용할 수 있다
         *  자료 타입이 고정되며, 가장 많이 사용하는 객체 생성 방식임
         * 제네릭스가 없는 경우 기본적으로 Object 타입으로 설정된다
         */
        List list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
    }
}