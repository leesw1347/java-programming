package ch15.part02.main2.sub4;

public class TestMain {
    public static void main(String[] args) {
        // 바로 앞 단원에서 사용하s fos.txt 파일을 대상파일로 선정
        String target = "D:\\IO\\io2.txt";
        String dest = "D:\\IO\\io2_copy.txt";

        try {
            // 파일 복사하기 모듈 사용
            FileUtils.copy(target, dest);
            System.out.println("복사성공");
        } catch (Exception e) {
            System.out.println("복사실패");
            e.printStackTrace();
        }
    }
}