package edu.iis.mto.multithread;

import org.junit.Test;
import org.mockito.Mockito;

public class BetterRadarTest {

    public PatriotBattery patriotBattery = Mockito.mock(PatriotBattery.class);

    @Test
    public void launchPatriotOneTimeInTheSameThread(){
        BetterRadar betterRadar = new BetterRadar(patriotBattery, 1,
                new MyExecutor(MyExecutor.MyExecuterType.THE_SAME_THREAD));
        betterRadar.notice(new Scud());
        Mockito.verify(patriotBattery, Mockito.times(1)).launchPatriot();
    }

    @Test
    public void launchPatriotTwoTimesInDifferentThread(){
        BetterRadar betterRadar = new BetterRadar(patriotBattery, 2,
                new MyExecutor(MyExecutor.MyExecuterType.DIFFERENT_THREAD));
        betterRadar.notice(new Scud());
        Mockito.verify(patriotBattery, Mockito.times(2)).launchPatriot();
    }

}