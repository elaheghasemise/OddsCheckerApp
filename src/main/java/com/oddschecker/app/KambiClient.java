package com.oddschecker.app;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddschecker.app.dto.LiveEventsGroup;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class KambiClient {

    static Logger log = Logger.getLogger(KambiClient.class);

    static final String URI = "https://eu-offering.kambicdn.org/offering/v2018/ubse/event/live/open.json";

    private KambiClient() {
    }

    public static LiveEventsGroup pollEvents() throws IOException {
        final URL url = new URL(URI);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();
        LiveEventsGroup liveEvents = new ObjectMapper().readValue(responseStream, LiveEventsGroup.class);
        responseStream.close();
        if (liveEvents == null || liveEvents.getLiveEvents() == null) {
            log.error("No data provided by Kambi API");
        }
        return liveEvents;
    }


}

