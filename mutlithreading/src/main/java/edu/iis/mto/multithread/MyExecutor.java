package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {

    public enum MyExecuterType {
            THE_SAME_THREAD, DIFFERENT_THREAD
    }

    private MyExecuterType myExecuterType;

    public MyExecutor(MyExecuterType myExecuterType){
        this.myExecuterType = myExecuterType;
    }

    @Override
    public void execute(Runnable command) {
        switch(myExecuterType){
            case THE_SAME_THREAD:
                command.run();
                break;
            case DIFFERENT_THREAD:
                new Thread(command).run();
                break;
        }
    }
}
