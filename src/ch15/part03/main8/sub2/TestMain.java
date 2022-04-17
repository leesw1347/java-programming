package ch15.part03.main8.sub2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class TestMain {
    public static void main(String[] args) {
        InputStream is = null;
        BufferedReader br = null;

        try {
            // URL 객체생성 -> URLConnection 객체 -> InputStream 객체
            URL url = new URL("https://naver.com");
            URLConnection connection = url.openConnection();
            is = connection.getInputStream();
            System.out.println(is);
            // InputStream 객체 -> InputStreamReader 객체 -> BufferedReader 객체
            // 인코딩 방식을 UTF-8로 설정
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            // 자료 읽기


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}