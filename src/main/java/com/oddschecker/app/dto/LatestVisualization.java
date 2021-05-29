package com.oddschecker.app.dto;

import lombok.Data;

@Data
public class LatestVisualization {
    private Long id;
    private Long eventId;
    private String occurrenceTypeId;
    private String periodId;
    private Visualization visualization;

}
