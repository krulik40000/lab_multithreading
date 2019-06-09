package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private PatriotBattery batteryMock;

    @Before
    public void initialize() {
        batteryMock = mock(PatriotBattery.class);
    }

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissileInDifferentThread() {
        ThreadExecutor executor = new ThreadExecutor(ThreadExecutorOption.FIRE_IN_NEW_THREAD);
        BetterRadar radar = new BetterRadar(batteryMock, insignificantNumberOfMissiles(), executor);
        radar.notice(new Scud());
        verify(batteryMock, times(insignificantNumberOfMissiles())).launchPatriot();
    }

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissileInTheSameThread() {
        ThreadExecutor executor = new ThreadExecutor(ThreadExecutorOption.FIRE_IN_SAME_THREAD);
        BetterRadar radar = new BetterRadar(batteryMock, insignificantNumberOfMissiles(), executor);
        radar.notice(new Scud());
        verify(batteryMock, times(insignificantNumberOfMissiles())).launchPatriot();

    }

    private int insignificantNumberOfMissiles() {
        return 7;
    }
}
