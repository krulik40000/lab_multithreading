package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Test;

public class BetterRadarTest {

    @Test public void launchPatriotSpecificAmountOfTimesWhenNoticesEnemyMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock, 5, new ThreadExecutor("diff");
        betterRadar.notice(new Scud());
        verify(batteryMock, times(5)).launchPatriot();
    }
}
