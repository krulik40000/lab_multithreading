package edu.iis.mto.multithread;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        ThreadExecutor executor = new ThreadExecutor(ThreadExecutorOption.FIRE_IN_NEW_THREAD);
        BetterRadar radar = new BetterRadar(batteryMock, insignificantNumberOfMissiles(), executor);
        radar.notice(new Scud());
        verify(batteryMock, times(insignificantNumberOfMissiles())).launchPatriot();
    }

    private int insignificantNumberOfMissiles() {
        return 7;
    }
}
