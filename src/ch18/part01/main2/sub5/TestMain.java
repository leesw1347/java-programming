package ch18.part01.main2.sub5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TestMain {
    public static void main(String[] args) {
        // HttpClient, HttpRequest, HttpResponse 클래스를 이용하여 처리하기
        // 위한 방법을 이해할 수 있다

        // 1) HttpRequest 객체 생성 및 기본설정
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                .uri(URI.create("https://n.news.naver.com/article/422/0000538282?mode=LPOD&cds=news_media_pc"))
                .build();

        // 2) HttpClient 객체 생성 및 기본 설정
        /**
         * HttpClient 객체 생성
         */
        HttpClient httpClient = HttpClient.newHttpClient();

        /**
         * 서버로 자료전송 - 요청자료(request)와 응답자료(BodyHandler)를 이용
         */
        CompletableFuture<HttpResponse<String>> future
                = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        /**
         * HttpResponse 결과자료를 받아와 body() 부분을 String으로 변환
         */
        CompletableFuture<String> future2
                = future.thenApply(new Function<HttpResponse<String>, String>() {
            @Override
            public String apply(HttpResponse<String> stringHttpResponse) {
                return stringHttpResponse.body();
            }
        });


    }
}