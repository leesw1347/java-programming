package ch15.part03.main8.sub2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        InputStream is = null;
        BufferedReader br = null;

        try {
            // URL 객체생성 -> URLConnection 객체 -> InputStream 객체
            URL url = new URL("https://naver.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            connection.setInstanceFollowRedirects(true);
            HttpURLConnection.setFollowRedirects(true);
//            System.out.println(headerFields.toString());
            is = connection.getInputStream();
            System.out.println(is);
            // InputStream 객체 -> InputStreamReader 객체 -> BufferedReader 객체
            // 인코딩 방식을 UTF-8로 설정
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            // 자료 읽기
            while (true) {
                String readLine = br.readLine();
                if (readLine == null) {
                    break;
                }
                System.out.println(readLine);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 종료작업
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}