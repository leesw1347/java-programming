package ch18.part02.main3.sub2;

public class TcpServer {
    public static void main(String[] args) {
        // 메인함수 - 테스트용
        new TcpServer().doServer();
    }

    /*
     접속 시 클라이언트의 쓰기작업과 읽기 작업 쓰레드 저장
        -> 서버 전체가 클라이언트에게 쓰기 작업할 때 필요함
     */
    private void doServer() {

    }
}