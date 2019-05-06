package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BatteryExecutor implements Executor {

    private int launchOption;

    public BatteryExecutor(int launchOption) {
        this.launchOption = launchOption;
    }

    @Override
    public void execute(Runnable command) {
        switch (launchOption){
            case 0 :
                command.run();
                break;
            case 1 :
                new Thread(command).run();
                break;
            default:
                System.out.println("No launch option set!");
                break;
        }
    }
}
