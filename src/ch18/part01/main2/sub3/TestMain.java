package ch18.part01.main2.sub3;

import java.net.MalformedURLException;
import java.net.URL;

public class TestMain {
    public static void main(String[] args) throws MalformedURLException {
        String path = "https://n.news.naver.com";
//        https://n.news.naver.com/article/422/0000538282?mode=LPOD&cds=news_media_pc
        path += "/article/422/0000538282?mode=LPOD&cds=news_media_pc";
        System.out.println(path);

        // URL 객체생성 및 함수 사용
        URL url = new URL(path);
        print("전체경로", path);
        print("getProtocol", url.getProtocol());
        print("getHost", url.getHost());
        print("getPort", url.getPort());
        print("getPath", url.getPath());
        print("getFile", url.getFile());
        print("getQuery", url.getQuery());
        print("getAuthority", url.getAuthority());
        print("getRef", url.getRef());
        print("getDefaultPort", url.getDefaultPort());
        System.out.println();
    }

    // 콘솔화면 출력을 위한 print() 함수 정의
    public static void print(String name, Object value) {
        System.out.println("[" + name + "] = " + value);
    }
}