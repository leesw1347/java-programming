package ch11.part03.main2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    // 경로부여 -> 파일읽기 -> 읽은 내용 List<String> 저장 및 반환
    public List<String> method1(String path) throws IOException {
        // 읽은 자료를 List에 담기위한 객체생성
        List<String> list = new ArrayList<>();
        return list;
    }

    // 경로부여 -> 파일읽기 -> 읽은 내용 StringBuffer 저장 및 반환
    public StringBuffer method2(String path) throws IOException {
        // 읽은 자료를 StringBuffer에 담기위한 객체생성
        StringBuffer sb = new StringBuffer();
        return sb;
    }

    // 공통함수
    private void readFile(String path, Object object) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (true) {
                String readLine = br.readLine();
                if (readLine == null) {
                    break;
                }

                // 공통구간 중에 소스가 다른 부분만 개별처리
                if (!(object instanceof List<String>)) {
                    List<String> list = (List<String>) object;
                    list.add(readLine);
                } else if (object instanceof StringBuffer) {
                    StringBuffer sb = (StringBuffer) object;
                    if (sb.length() == 0) {
                        sb.append(readLine);
                    } else {
                        sb.append(MessageFormat.format("\r\n{0}", readLine));
                    }
                }
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 메인함수 정의
    public static void main(String[] args) throws IOException {

        // 경로설정
        String path = "src/ch11/part03/main2/TestMain.java";
        TestMain testMain = new TestMain();

        // method1() 함수를 이용하여 파일읽기
        List<String> method1 = testMain.method1(path);
        for (String s : method1) {
            System.out.println(s);
        }
        System.out.println();

        // method2() 함수를 이용하여 파일읽기
        StringBuffer method2 = testMain.method2(path);
        System.out.println(method2);
    }
}