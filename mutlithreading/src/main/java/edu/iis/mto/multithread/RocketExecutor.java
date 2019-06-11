package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class RocketExecutor implements Executor {

    public enum RocketExecutorType{
        SAME_THREAD, DIFF_THREAD
    }

    private RocketExecutorType rocketExecutorType;

    public RocketExecutor(RocketExecutorType rocketExecutorType) {
        this.rocketExecutorType = rocketExecutorType;
    }

    @Override
    public void execute(Runnable command){
        if(rocketExecutorType.equals(RocketExecutorType.DIFF_THREAD)){
            new Thread(command).run();
        }
        else if(rocketExecutorType.equals(RocketExecutorType.SAME_THREAD)){
            command.run();

        }
    }

}
