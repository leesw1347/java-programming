package ch18.part03.main2.sub2;


/**
 * 추상 메소드의 예외 처리는 처음부터 정의하지 않았으며,
 * TcpClient에서 구현하면서 예외 처리를 필요로 하며
 * 이후 추상 메소드에 부여하였다.
 */
public abstract class AbstractClientSocket {
    protected String name;
    protected IClientUser clientUser;

    // 해당 생성자 함수를 강제적으로 처리하기 위해서 추상클래스 사용
    public AbstractClientSocket(String name, IClientUser clientUser) {
        this.name = name;
        this.clientUser = clientUser;
    }

    // 추상메소드 정의
}