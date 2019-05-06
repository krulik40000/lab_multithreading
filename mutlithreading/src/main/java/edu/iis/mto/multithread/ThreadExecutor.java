package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class ThreadExecutor implements Executor {

    String threadType = null;

    public ThreadExecutor(String threadType){
        this.threadType = threadType;
    }

    @Override public void execute(Runnable command){
        if (threadType.equals("same")){
            command.run();
        } else if (threadType.equals("diff")){
            new Thread(command).run();
        }
    }

}
