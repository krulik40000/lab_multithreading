package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private PatriotBattery battery;
    private Executor executor;
    private int rocketAmount;
    
    public BetterRadar(PatriotBattery battery, Executor executor, int rocketAmount) {
        super();
        this.battery = battery;
        this.executor = executor;
        this.rocketAmount = rocketAmount;
    }
    
    public void notice(Scud enemyMissile) {
        
    }
    
    
}
