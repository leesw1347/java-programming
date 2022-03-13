package ch09.part02.main8.sub1;

/**
 * 객체 생성 및 업캐스팅, 다운캐스팅
 * 업캐스팅 된 객체 다운캐스팅
 */
public class TestMain {
    public static void main(String[] args) {
        /**
         * 객체생성 및 업캐스팅
         */
        System.out.println("1. 객체생성 및 업캐스팅");
        ChildImpl child1 = new ChildImpl();
        IParent child2 = child1;
        IChild child3 = child1;
        System.out.println("\tchild1==child2 = " + (child1 == child2));
        System.out.println("\tchild1==child3 = " + (child1 == child3));

        /**
         * 업캐스팅 된 객체 다운캐스팅
         */
        System.out.println("2. 업캐스팅 된 객체 다운캐스팅");
        ChildImpl child4 = (ChildImpl) child2;
        ChildImpl child5 = (ChildImpl) child3;
        System.out.println("\tchild1==child4 = " + (child1 == child4));
        System.out.println("\tchild1==child5 = " + (child1 == child5));

        /**
         * 다운캐스팅 오류
         */
        System.out.println("3. 업캐스팅 오류");
        ParentImpl parent1 = new ParentImpl();
        IParent parent2 = parent1;
        System.out.println("\tparent1 == parent2 = " + (parent1 == parent2));
//        IChild parent3 = (IChild) parent1; // 오류 발생
    }
}
