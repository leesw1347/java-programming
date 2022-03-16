package ch09.part03.main6;

import com.sun.tools.javac.Main;

import javax.sound.sampled.Port;

public class MainProcess extends AbstractMainProcess {

    // setConfig() 추상 메소드 재정의
    @Override
    public void setConfig() {
        System.out.println("MainProcessImpl 환경설정");
    }

    // addProcesses() 추상 메소드 재정의
    @Override
    public IProcess[] addProcesses() {
        IProcess process1 = new Process1();
        IProcess process2 = new Process2();
        IProcess process3 = new Process3();
        IProcess[] process_list = {process1, process2, process3};
        return process_list;
    }

    /**
     * 메인 함수 정의
     * 객체 생성 및 main() 함수 호출
     */
    public static void main(String[] args) {
        // 객체 생성 및 추상 클래스의 main() 함수 호출
        MainProcess mainProcess = new MainProcess();
        mainProcess.main();
    }
}
