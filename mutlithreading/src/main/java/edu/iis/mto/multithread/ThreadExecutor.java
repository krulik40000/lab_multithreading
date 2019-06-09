package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class ThreadExecutor implements Executor {

    ThreadExecutorOption launchOption;

    public ThreadExecutor(ThreadExecutorOption launchOption) {
        this.launchOption = launchOption;
    }

    @Override
    public void execute(Runnable command) {
        switch (launchOption) {
            case FIRE_IN_SAME_THREAD:
                command.run();
                break;
            case FIRE_IN_NEW_THREAD:
                new Thread(command).start();
                break;
        }
    }
}
