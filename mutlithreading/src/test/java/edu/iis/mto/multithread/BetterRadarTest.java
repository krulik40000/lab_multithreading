package edu.iis.mto.multithread;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BetterRadarTest {

    public PatriotBattery patriotBattery = Mockito.mock(PatriotBattery.class);

    @Test
    public void launchPatriotOneTimeInTheSameThread(){
        BetterRadar betterRadar = new BetterRadar(patriotBattery, 1,
                new MyExecutor(MyExecutor.MyExecuterType.THE_SAME_THREAD));
        betterRadar.notice(new Scud());
        Mockito.verify(patriotBattery, Mockito.times(1)).launchPatriot();
    }
}