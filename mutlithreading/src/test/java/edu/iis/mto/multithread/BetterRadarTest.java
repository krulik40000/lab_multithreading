package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BetterRadarTest {

    @Mock
    PatriotBattery patriotBattery;
    
    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        MockitoAnnotations.initMocks(this);
        BetterRadar betterRadar = new BetterRadar(patriotBattery,new BatteryExecutor(true),3);
        betterRadar.notice(new Scud());
        verify(patriotBattery,times(3)).launchPatriot();
    }

}
