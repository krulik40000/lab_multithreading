package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class ThreadExecutor implements Executor {

   ExecutorType executorType;

    public ThreadExecutor(ExecutorType executorType){
        this.executorType = executorType;
    }

    @Override public void execute(Runnable command){
        if (this.executorType == ExecutorType.SAME_THREAD) {
            command.run();
        } else {
            new Thread(command).run();
        }
    }

    public ExecutorType getExecutorType(){
        return executorType;
    }

    public void setExecutorType(ExecutorType executorType){
        this.executorType = executorType;
    }

}
