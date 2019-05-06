package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable {

    private PatriotBattery patriotBattery;
    private int count;
    private Executor executor;

    public BetterRadar(PatriotBattery patriotBattery, int count, Executor executor){
        this.patriotBattery = patriotBattery;
        this.count = count;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle){
        launchPatriot();
    }

    private void launchPatriot(){
        executor.execute(this);
    }

    @Override public void run(){
        for(int i = 0; i < count; i++) {
            patriotBattery.launchPatriot();
        }
    }
}
