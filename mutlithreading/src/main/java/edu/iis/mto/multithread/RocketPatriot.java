package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RocketPatriot {
    private boolean isMultithreaded;
    private ExecutorService service;

    public RocketPatriot(boolean multiThreaded) {
        this.isMultithreaded = multiThreaded;
        service = Executors.newCachedThreadPool();
    }

    void patriotRockets(PatriotBattery battery, int salvoSize) {
        for (int i = 0; i < salvoSize; i++) {
            if (isMultithreaded)
                service.submit(() -> battery.launchPatriot());
            else
                battery.launchPatriot();
        }
    }
}
