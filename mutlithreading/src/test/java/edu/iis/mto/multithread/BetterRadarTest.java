package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Mock
    PatriotBattery batteryMock;
    @Before
    public void setUp() {
        batteryMock = mock(PatriotBattery.class);
    }

    @Test
    @RepeatRule.Repeat(times = 20)
    public void launchTwoRocketsInTestThread() {

        RocketPatriot patriot = new RocketPatriot(false);
        BetterRadar radar = new BetterRadar(batteryMock, patriot, 2);

        radar.notice(new Scud());
        verify(batteryMock, times(2)).launchPatriot();
    }


}