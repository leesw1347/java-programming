package ch09.part03.main6;

import ch09.part03.main6.AbstractMainProcess.IProcess;

public class Process1 implements IProcess {
    @Override
    public void execute() {
        System.out.println("Process1 절차 실행");
    }
}
