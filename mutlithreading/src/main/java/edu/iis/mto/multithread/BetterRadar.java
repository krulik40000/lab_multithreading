package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable {

    private PatriotBattery battery;
    private int numberOfMissiles;
    private Executor executor;

    public BetterRadar(PatriotBattery battery, int numberOfMissiles, Executor executor) {
        this.battery = battery;
        this.numberOfMissiles = numberOfMissiles;
        this.executor = executor;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.execute(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfMissiles; i++) {
            battery.launchPatriot();
        }
    }
}
