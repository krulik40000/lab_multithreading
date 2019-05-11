package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Mock
    PatriotBattery batteryMock;
}