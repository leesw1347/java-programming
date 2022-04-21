package ch18.part01.main2.sub5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * 1. 자료 요청을 위한 객체 생성 및 기본 설정
 * 2. 자료 전송을 위한 객체 생성
 * 응답 자료 처리 객체 생성 - 자료를 UTF-8로 인코딩하여 처리하여 String 타입으로 수신
 * 자료 전송 및 HttpResponse 객체 반환
 * thenApply(): HttpResponse의 body() 자료를 String으로 변환
 * thenAccept() : String 자료를 콘솔 화면에 출력
 * join() : 비동기 작업이 종료될 때까지 메인 쓰레드 대기
 */
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

        /**
         * String으로 변환한 자료를 콘솔화면에 나타내기
         */
        future2.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        future2.join();

        /**
         * 람다와 스트림을 학습한 이후에 위의 HttpClient 객체 생성 및 기본 설정 부분을 아래와 같이
         * 간단하게 설정할 수 있다
         */
        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println).join();
    }
}