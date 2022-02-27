package ch07.main1.part02.main1;

public class TestMain {
    /**
     * TypeA 객체 생성 1,2,3,4,5
     */
    public static void main(String[] args) {
        System.out.println("객체1 생성");
        TypeA typeA1 = new TypeA();

        System.out.println("객체2 생성");
        TypeA typeA2 = new TypeA();

        System.out.println("객체3 생성");
        TypeA typeA3 = new TypeA();

        System.out.println("객체4 생성");
        TypeA typeA4 = new TypeA("생성자 파라미터1");

        System.out.println("객체5 생성");
        TypeA typeA5 = new TypeA("생성자 파라미터2");
    }
}