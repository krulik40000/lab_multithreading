package edu.iis.mto.multithread;

import org.junit.Test;
import org.mockito.Mockito;

public class BetterRadarTest {


    public PatriotBattery battery = Mockito.mock(PatriotBattery.class);

    @Test
    public void launchPatriotOnlyOneTimeInTheSameThread(){
        BetterRadar betterRadar = new BetterRadar(battery, 1,
                new MyRocketExecutor(MyRocketExecutor.RocketExecutorType.SAME_THREAD));
        betterRadar.notice(new Scud());
        Mockito.verify(battery, Mockito.times(1)).launchPatriot();
    }

}
