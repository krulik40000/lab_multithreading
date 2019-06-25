package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable{

    private Executor executor;
    private PatriotBattery patriotBattery;
    private int amountOfMissilesToFire;

    public BetterRadar(Executor executor, PatriotBattery patriotBattery, int amountOfMissilesToFire) {
        this.executor = executor;
        this.patriotBattery = patriotBattery;
        this.amountOfMissilesToFire = amountOfMissilesToFire;
    }

    public void notice(Scud enemyMissile){
        launchPatriot();
    }

    private void launchPatriot(){
        executor.execute(this);
    }

    @Override
    public void run() {
        for(int i = 0; i < amountOfMissilesToFire; i++){
            patriotBattery.launchPatriot();
        }
    }
}
