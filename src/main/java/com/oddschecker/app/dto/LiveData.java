package com.oddschecker.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class LiveData {
    private Long eventId;
    private MatchClock matchClock;
    private Score score;
    private Statistics statistics;
    private List<LiveStatistics> liveStatistics;
    private LatestVisualization latestVisualization;

}
