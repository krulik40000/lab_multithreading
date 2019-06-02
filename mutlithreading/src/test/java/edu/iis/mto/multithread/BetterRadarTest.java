package edu.iis.mto.multithread;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class BetterRadarTest {

    public PatriotBattery battery = Mockito.mock(PatriotBattery.class);



    @Test
    public void launch_patriot_one_time_when_notice_enemy_missle_on_different_thread(){

        RocketExecutor rocketExecutor = new RocketExecutor(RocketExecutor.RocketExecutorType.DIFF_THREAD);
        BetterRadar betterRadar = new BetterRadar(battery,1,rocketExecutor);

        betterRadar.notice(new Scud());

        Mockito.verify(battery , Mockito.times(1)).launchPatriot();

    }

}
