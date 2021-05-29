package com.oddschecker.app;

import com.oddschecker.app.dto.LiveEvent;
import com.oddschecker.app.dto.LiveEventsGroup;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Scheduler {

    Logger log = Logger.getLogger(Scheduler.class);

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public void process(Long eventId) throws IOException {
        LiveEventsGroup events = KambiClient.pollEvents();
        Optional<LiveEvent> event = events.getLiveEvents().stream().filter(le -> le.getEvent().getId().equals(eventId)).findFirst();
        if (!event.isPresent() || event.get().getMainBetOffer() == null || event.get().getMainBetOffer().getOutcomes() == null) {
           log.warn("No odds available for event: " + eventId);
            return;
        }
        log.info("Event: " + event.get().getEvent().getName());
        executor.scheduleAtFixedRate(new PollOdds(eventId), 0, 10, SECONDS);
    }

}


