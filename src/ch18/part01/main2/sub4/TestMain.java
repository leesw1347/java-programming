package ch18.part01.main2.sub4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class TestMain {
    public static void main(String[] args) throws IOException {
        // URL 객체생성
        URL url = new URL("https://n.news.naver.com/article/422/0000538282?mode=LPOD&cds=news_media_pc");
        print("URL 원본", url.toString());

        // openConnection() -> URLConnection 객체 -> getInputStream() 함수 사용
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();

        // 네트워크로부터 들어오는 자료 읽기
        /**
         * InputStream
         *  -> InputStreamReader: UTF-8 디코딩
         *  -> BufferedReader: readLine() 함수를 이용하기 위함
         */
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(
                                is, StandardCharsets.UTF_8
                        )
                );

        while (true) {
            String readLine = br.readLine();
            if (readLine == null) {
                break;
            }
            System.out.println(readLine);
        }
        br.close();
    }

    // 콘솔화면 출력을 위한 print() 함수 정의
    public static void print(String name, Object value) {
        System.out.println("[" + name + "] = " + value);
    }
}