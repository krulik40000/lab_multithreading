package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class MyRocketExecutor implements Executor {

    public enum RocketExecutorType{
        SAME_THREAD, OTHER_THREAD
    }

    private RocketExecutorType rocketExecutorType;

    public MyRocketExecutor(RocketExecutorType rocketExecutorType) {
        this.rocketExecutorType = rocketExecutorType;
    }

    @Override
    public void execute(Runnable command){
        if(rocketExecutorType.equals(RocketExecutorType.OTHER_THREAD)){
            new Thread(command).run();
        }
        else if(rocketExecutorType.equals(RocketExecutorType.SAME_THREAD)){
            command.run();

        }
    }
}
