package com.oddschecker.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class LiveEventsGroup {
    private List<LiveEvent> liveEvents;
    @JsonIgnore
    private Group group;
}
