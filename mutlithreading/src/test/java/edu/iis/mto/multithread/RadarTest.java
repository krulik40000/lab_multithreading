package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;


public class RadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();


    @Test
    @RepeatRule.Repeat(times = 1000)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(batteryMock,
                1, new MyExecutor(MyExecutor.MyExecuterType.THE_SAME_THREAD));
        betterRadar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
