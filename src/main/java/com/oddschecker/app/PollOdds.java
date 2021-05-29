package com.oddschecker.app;

import com.oddschecker.app.dto.LiveEvent;
import com.oddschecker.app.dto.LiveEventsGroup;
import com.oddschecker.app.dto.Outcomes;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


public class PollOdds implements Runnable {
    static Logger log = Logger.getLogger(PollOdds.class);

    private static LocalDateTime lastChangedDate;
    private Long eventId;

    public PollOdds(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public void run() {
        try {
            LiveEventsGroup events = KambiClient.pollEvents();
            Optional<LiveEvent> event = events.getLiveEvents().stream().filter(le -> le.getEvent().getId().equals(eventId)).findFirst();
            if (!event.isPresent() || event.get().getMainBetOffer() == null || event.get().getMainBetOffer().getOutcomes() == null) {
                return;
            }
            Optional<String> outcomes = getOutcomesString(event.get());
            if (outcomes.isPresent()) {
                log.info(outcomes.get());
            }
        } catch (IOException e) {
            log.error("Failed to poll odds: {}", e);
        }
    }

    private Optional<String> getOutcomesString(LiveEvent event) {
        String name = event.getEvent().getName();
        List<Outcomes> outcomes = event.getMainBetOffer().getOutcomes();
        if (!newOddsAvailable(outcomes.get(0).getChangedDate())) {
            return Optional.empty();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(format(LocalDateTime.now())).append("]  | ");
        outcomes.forEach(mb -> {
            String label = mb.getLabel();
            if (label.equals("1")) {
                label = name.split("-")[0];
            } else if (mb.getLabel().equals("2")) {
                label = name.split("-")[1];
            }
            stringBuilder.append(label).append(":  ").append(format(mb.getOdds().doubleValue())).append(" | ");
        });
        return Optional.of(stringBuilder.toString());
    }

    private static boolean newOddsAvailable(String newChangeDateString) {
        LocalDateTime newChangeDate = LocalDateTime.parse(newChangeDateString.substring(0, 19));
        if (lastChangedDate != null && lastChangedDate.isEqual(newChangeDate)) {
            return false;
        }
        lastChangedDate = newChangeDate;
        return true;
    }

    private static String format(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        return formatter.format(dateTime);
    }

    private static BigDecimal format(Double odds) {
        return BigDecimal.valueOf(odds / 1000).setScale(2, RoundingMode.HALF_UP);
    }
}
