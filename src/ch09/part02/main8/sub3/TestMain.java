package ch09.part02.main8.sub3;

public class TestMain {
    /**
     * 메인 함수 정의
     * 예/아니오 팝업창 띄우기
     * 예 처리를 위한 로직 구현 (생략)
     * 아니요 처리를 위한 로직 구현 (생략)
     */

    public static void main(String[] args) {
        // 예, 아니요 팝업창 띄우기
        ConfirmUtil.confirmWindow(new IConfirm() {
            @Override
            public String yesWork() {
                // "예" 처리를 위한 로직구현
                return "'예'를 선택하였습니다";
            }

            @Override
            public String noWork() {
                return "'아니요'를 선택하였습니다";
            }
        });
    }

}
