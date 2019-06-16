package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BetterRadarTest {
    public PatriotBattery battery;

    @Before
    public void setUp() {
        battery = Mockito.mock(PatriotBattery.class);
    }

    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriotOnlyOneTimeInTheSameThread(){
        BetterRadar betterRadar = new BetterRadar(battery, 1,
                new MyRocketExecutor(MyRocketExecutor.RocketExecutorType.SAME_THREAD));
        betterRadar.notice(new Scud());
        Mockito.verify(battery, Mockito.times(1)).launchPatriot();
    }

    @Test
    public void launchPatriotFiveTimesInDifferentThread(){
        BetterRadar betterRadar = new BetterRadar(battery, 5,
                new MyRocketExecutor(MyRocketExecutor.RocketExecutorType.OTHER_THREAD));
        betterRadar.notice(new Scud());
        Mockito.verify(battery, Mockito.times(5)).launchPatriot();
    }
}
