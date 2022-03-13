package ch09.part02.main8.sub3;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;

public class ConfirmUtil {
    /**
     * confirmWindow() 함수 정의
     * 사용자가 기능 정의를 할 수 있도록 IConfirm 인터페이스를 파라미터로 지정
     * 확인 창 (0: 선택), (1: 아니요), (2: 취소)
     * 예 선택 시 업무 처리 - 사용자가 정의한 yesWork() 함수 실행
     * 아니요 선택 시 업무 처리 - 사용자가 정의한 noWork() 함수 실행
     * 취소 선택 시 업무 처리
     */

    // 사용자가 기능정의를 할 수 있도록 IConfirm 인터페이스를 파라미터로 지정
    public static void confirmWindow(IConfirm confirm) {
        /**
         * 확인창 : 0:예, 1: 아니요, 2:취소
         */
        String msg = "자료를 저장하시겠습니까?";
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, msg);

        // "예" 선택 시 업무처리 - 사용자가 정의한 yesWork() 함수 실행
        if (showConfirmDialog == 0) {
            String yesWork = confirm.yesWork();
            JOptionPane.showMessageDialog(null, yesWork);
        }

        // 아니요를 선택 시 업무처리 - 사용자가 정의한 noWork() 함수 실행
        else if (showConfirmDialog == 1) {
            msg = confirm.noWork();
            JOptionPane.showMessageDialog(null, msg);
        }
        // 취소 선택 시 업무처리
        else {
            JOptionPane.showMessageDialog(null, "취소하였습니다");
        }
    }
}