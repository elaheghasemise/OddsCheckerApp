package com.oddschecker.app;

import com.oddschecker.app.dto.LiveEventsGroup;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class KambiClientTest {

    KambiClient unitUnderTest;

    @Test
    public void testPollEvents() throws IOException {
        LiveEventsGroup list = unitUnderTest.pollEvents();
        Assert.assertNotNull(list);
    }


}
