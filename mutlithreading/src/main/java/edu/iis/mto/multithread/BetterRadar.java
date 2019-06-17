package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable{

    private Executor executor;
    private PatriotBattery patriotBattery;
    private int firedMissiles;

    public BetterRadar(Executor executor, PatriotBattery patriotBattery, int firedMissiles) {
        this.executor = executor;
        this.patriotBattery = patriotBattery;
        this.firedMissiles = firedMissiles;
    }

    public void notice(Scud enemyMissle){
        launchPatriot();
    }

    private void launchPatriot(){
        executor.execute(this);
    }

    @Override
    public void run() {
        for(int i = 0; i < firedMissiles; i++){
            patriotBattery.launchPatriot();
        }
    }
}
