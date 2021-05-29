package com.oddschecker.app.dto;

import lombok.Data;

@Data
public class MatchClock {
    private Integer minute;
    private Integer second;
    private Integer minutesLeftInPeriod;
    private Integer secondsLeftInMinute;
    private boolean running;
    private boolean disabled;
    private String period;
}
