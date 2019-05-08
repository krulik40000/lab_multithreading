package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BatteryExecutor implements Executor {

    private LaunchOption launchOption;

    public BatteryExecutor(LaunchOption launchOption) {
        this.launchOption = launchOption;
    }

    @Override
    public void execute(Runnable command) {
        switch (launchOption){
            case THIS_THREAD:
                command.run();
                break;
            case ANOTHER_THREAD:
                new Thread(command).run();
                break;
            default:
                System.out.println("No launch option set!");
                break;
        }
    }
}
