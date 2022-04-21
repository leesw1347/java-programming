package ch18.part01.main2.sub3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TestMain {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        String path = "https://n.news.naver.com";
//        https://n.news.naver.com/article/422/0000538282?mode=LPOD&cds=news_media_pc
        path += "/article/422/0000538282?mode=LPOD&cds=news_media_pc";
        System.out.println(path);

        // URL 객체생성 및 함수 사용
        URL url = new URL(path);
        print("전체경로", path);
        print("getProtocol", url.getProtocol());
        print("getHost", url.getHost());
        print("get  Port", url.getPort());
        print("getPath", url.getPath());
        print("getFile", url.getFile());
        print("getQuery", url.getQuery());
        print("getAuthority", url.getAuthority());
        print("getRef", url.getRef());
        print("getDefaultPort", url.getDefaultPort());
        print("toExternalForm", url.toExternalForm());
        System.out.println();

        // URI 객체생성 및 함수 사용
        URI uri = url.toURI();
        System.out.println("URI 함수");
        print("getSchema", uri.getScheme());
        print("getHost", uri.getHost());
        print("getPort", uri.getPort());
        print("getPath", uri.getPath());
        print("getRawPath", uri.getRawPath());
        print("getQuery", uri.getQuery());
        print("getRawQuery", uri.getRawQuery());
        print("getAuthority", uri.getAuthority());
        print("getRawAuthority", uri.getRawAuthority());
        print("getRawFragment", uri.getRawFragment());
        print("getSchemeSpecificPart", uri.getSchemeSpecificPart());
        print("toASCIIString", uri.toASCIIString());
        print("toString", uri.toString());
        System.out.println();

        URI uri2 = new URI("https://www.website.com/path1/../../path2/file.jsp");
        URI uri3 = uri2.normalize();
        print("uri2 변경 전", uri2.toString());
        print("uri3 변경 후", uri3.toString());
        System.out.println();

        URI uri4 = new URI("/path1/path2/file.jsp");
        print("uri3 uri", uri3.toString());
        print("uri4 isAbsolute", uri3.isAbsolute());
        System.out.println();

//        URI uri5 =
        URI uri5 = new URI("http://example.com/something/more/long");
        URI uri6 = new URI("/path1/path2/file.jsp");
        URI uri7 = uri5.resolve(uri6); // url6의 full schema를 가져온 뒤, uri5를 붙힌다.

        print("uri5 경로", uri5.toString());
        print("uri6 상대경로", uri6.toString());
        print("uri7 resolve uri", uri7.toString());
    }

    // 콘솔화면 출력을 위한 print() 함수 정의
    public static void print(String name, Object value) {
        System.out.println("[" + name + "] = " + value);
    }
}