package ch09.part02.main1;

import javax.swing.*;
import java.awt.*;

public class ConfirmUtil {
    /**
     * @summary 예, 아니요를 선택팝업창을 띄우기 위한 함수 정의
     * @param component 해당 팝업창을 호출하게 하는 화면 객체
     *                    null일 경우, 윈도우 화면 중앙에 팝업창이 나타난다
     * @param confirm: 예, 아니요 로직 구현 클래스
     */
    public static void confirmWindow(Component component, ConfirmWindowWork confirm) {
        /**
         확인창 0('예' 선택), 1('아니요', 선택), 2('취소', 선택)
         */

        String msg = "자료를 저장하시겠습니까?";
        int showConfirm = JOptionPane.showConfirmDialog(component, msg);

        /**
         * "예" 선택 시 업무처리
         */
        if (showConfirm == 0) {
            String yesWork = confirm.yesWork();
            JOptionPane.showMessageDialog(component, msg);
        }

        /**
         * 아니요 선택 시 업무처리
         */
        else if (showConfirm == 1) {
            msg = confirm.noWork();
            JOptionPane.showMessageDialog(component, msg);
        }
    }

    /**
     * 모듈 사용 시 기능목록을 사용자가 정의할 수 있도록 인터페이스 정의
     */
    public interface ConfirmWindowWork {
        /**
         * 팝업에서 '예'를 클릭할 때 처리하기 위한 함수정의
         */
        public String yesWork();

        /**
         * 팝업에서 '아니요'를 클릭할 때 처리하기 위한 함수정의
         */
        public String noWork();
    }
}
