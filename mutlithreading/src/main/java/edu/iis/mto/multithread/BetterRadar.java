package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery battery;
    private RacketPatriot patriot;
    private final int SALVO_SIZE;

    public BetterRadar(PatriotBattery battery, RacketPatriot patriot, int rocketPackSize) {
        this.SALVO_SIZE = rocketPackSize;
        this.battery = battery;
        this.patriot = patriot;
    }

    public void notice(Scud enemyMissle) {
        this.patriot.patriotRockets(this.battery, SALVO_SIZE);
    }

}
