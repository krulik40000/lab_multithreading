package edu.iis.mto.multithread;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class BetterRadarTest {

    public PatriotBattery battery = Mockito.mock(PatriotBattery.class);



    @Test
    public void launch_patriot_n_times_when_notice_enemy_missle_on_different_thread(){

        int n = 5;
        RocketExecutor rocketExecutor = new RocketExecutor(RocketExecutor.RocketExecutorType.DIFF_THREAD);
        BetterRadar betterRadar = new BetterRadar(battery,n,rocketExecutor);

        betterRadar.notice(new Scud());

        Mockito.verify(battery , Mockito.times(n)).launchPatriot();

    }

    @Test
    public void lunch_patriot_n_times_when_notice_enemy_missle_on_same_thread(){

        int n = 123;
        RocketExecutor rocketExecutor = new RocketExecutor(RocketExecutor.RocketExecutorType.SAME_THREAD);
        BetterRadar betterRadar = new BetterRadar(battery,n,rocketExecutor);

        betterRadar.notice(new Scud());

        Mockito.verify(battery , Mockito.times(n)).launchPatriot();

    }

}
