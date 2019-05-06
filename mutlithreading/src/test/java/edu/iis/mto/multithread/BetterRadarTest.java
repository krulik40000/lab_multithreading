package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {

    @Rule public RepeatRule repeatRule = new RepeatRule();

    @Repeat(times = 20)

    @Test public void launchPatriotSpecificAmountOfTimesWhenNoticesEnemyMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, 10, new ThreadExecutor("same");
        betterRadar.notice(new Scud());
        verify(batteryMock, times(10)).launchPatriot();
    }
}
