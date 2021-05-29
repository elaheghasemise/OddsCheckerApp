package com.oddschecker.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class Event {
    private Long id;
    private String name;
    private String nameDelimiter;
    private String englishName;
    private String homeName;
    private String awayName;
    private String start;
    private String group;
    private String groupId;
    private List<Path> path;
    private Integer nonLiveBoCount;
    private Integer liveBoCount;
    private String sport;
    private List<String> tags;
    private String state;
    private Integer sortOrder;
    @JsonIgnore
    private ExtraInfo extraInfo;
}
