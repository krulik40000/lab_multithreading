package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

public class RadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery battery = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(battery, 1, new MyRocketExecutor(MyRocketExecutor.RocketExecutorType.OTHER_THREAD));
        betterRadar.notice(new Scud());
        verify(battery).launchPatriot();
    }

}
