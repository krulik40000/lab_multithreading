package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class LaunchExecutor implements Executor {

    private LaunchOption launchOption;

    public LaunchExecutor(LaunchOption launchOption) {
        this.launchOption = launchOption;
    }

    @Override
    public void execute(Runnable runnable) {
        switch (launchOption){
            case CURRENT_THREAD:
                runnable.run();
                break;
            case NEXT_THREAD:
                new Thread(runnable).run();
                break;
            default:
                break;
        }
    }
}
