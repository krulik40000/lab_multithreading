package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private PatriotBattery batteryMock;

    @Rule
    public RepeatRule rule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 12)
    public void launchPatriotWhenNoticesAScudMissileInTheSameThread() {
        batteryMock = mock(PatriotBattery.class);
        ThreadExecutor executor = new ThreadExecutor(ThreadExecutorOption.FIRE_IN_SAME_THREAD);
        BetterRadar radar = new BetterRadar(batteryMock, insignificantNumberOfMissiles(), executor);
        radar.notice(new Scud());
        verify(batteryMock, times(insignificantNumberOfMissiles())).launchPatriot();
    }

    private int insignificantNumberOfMissiles() {
        return 7;
    }
}
