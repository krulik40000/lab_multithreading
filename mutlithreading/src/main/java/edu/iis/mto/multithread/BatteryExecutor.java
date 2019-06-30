package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BatteryExecutor implements Executor{

    private boolean theSameThread;

    public BatteryExecutor(boolean theSameThread) {
        super();
        this.theSameThread = theSameThread;
    }

    @Override
    public void execute(Runnable lauchPatriotTask) {
        if(theSameThread) {
            lauchPatriotTask.run();
        }
        else {
            new Thread(lauchPatriotTask).run();
        }
    }
}
