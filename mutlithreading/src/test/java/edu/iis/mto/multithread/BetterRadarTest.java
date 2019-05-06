package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private PatriotBattery patriotBattery;

    private BetterRadar betterRadar;

    @Before
    public void init(){
        patriotBattery = mock(PatriotBattery.class);
    }

    @Test
    public void launchMisslesWhenNoticedEnemyMissleTest(){
        betterRadar = new BetterRadar(new BatteryExecutor(0), patriotBattery, 10);
        betterRadar.notice(new Scud());
        verify(patriotBattery, times(10)).launchPatriot();
    }

}
