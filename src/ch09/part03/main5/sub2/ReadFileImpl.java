package ch09.part03.main5.sub2;

/**
 * 클래스 모듈화
 * [1]. 추상 클래스를 이용한 모듈화
 *  클래스로 구성이 되어 하나의 타입으로 사용된다
 *  해당 타입으로 객체 생성 후 파라미터로 전달이 가능하다.
 *  업무 절차를 갖는 프레임 구성에 있어서 매우 편리하다
 *  업무 절차를 구성 후 해당 가이드대로 로직만 구성하면 된다.
 */
public class ReadFileImpl extends AbstractReadFile {
    // 파일 경로를 설정하기위한 getFilePath() 함수 재정의
    @Override
    public String getFilePath() {
        return "src/ch09/part03/main5/sub1/ReadProcess.java";
    }

    // 파일을 한줄씩 읽어 로직 처리하기 위한 process() 함수 재정의
    @Override
    public void process(String readLine) {
        if (!readLine.trim().equals("")) {
            System.out.println(readLine);
        }
    }

    public static void main(String[] args) throws Exception {
        // ReadFileImpl 객체생성 및 read() 함수 호출
        ReadFileImpl r = new ReadFileImpl();
        r.read();
    }
}
