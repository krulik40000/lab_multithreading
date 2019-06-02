package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable {

    private PatriotBattery battery;
    private int numberOfRockets;
    private Executor executor;



        public BetterRadar(PatriotBattery battery, int numberOfRockets) {
            this.battery = battery;
            this.numberOfRockets = numberOfRockets;
        }

        public void notice(Scud enemyMissle) {
            launchPatriot();
        }

        private void launchPatriot() {
        executor.execute(this::run);
        }

        @Override
        public void run() {
            for (int i = 0; i < numberOfRockets; i++) {
                battery.launchPatriot();
            }
        }
}
