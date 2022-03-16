package ch09.part03.main6;

import ch09.part03.main5.sub3.IReadProcess;

// 절차성 모듈을 개발할 때 추상클래스를 이용하여 업무처리를 위한 로직을 구현하고자 한다
public abstract class AbstractMainProcess {
    /**
     * 절차 처리를 위한 인터페이스 정의
     * 절차 업무 처리를 위한 execute() 함수 정의
     */

//     * 사용자의 환경에 맞게 설정을 하기 위한 추상 메소드 정의
    public abstract void setConfig();

    // 주요업무처리를 위한 추상메소드 정의
    public abstract IProcess[] addProcesses();

    // 업무처리를 위한 절차를 갖는 메인함수
    public final void main() {
        // 절차1. 환경 설정
        setConfig();

        // 절차2. 사용자 등록 절차 처리
        IProcess[] processes = addProcesses();
        if (processes != null) {
            for (IProcess p : processes) {
                // 절차3. 절차처리
                p.execute();
            }
        }
    }

    public interface IProcess {
        // 절차 업무 처리를 위한 execute 함수정의
        public void execute();
    }
}