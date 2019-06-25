package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 20)
    public void launchMisslesWhenNoticedEnemyMissleTest(){
        PatriotBattery patriotBattery = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(new BatteryExecutor(LaunchOption.THIS_THREAD), patriotBattery, 10);
        betterRadar.notice(new Scud());
        verify(patriotBattery, times(10)).launchPatriot();
    }

}
