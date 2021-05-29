package com.oddschecker.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class Criterion {
    private Long id;
    private String label;
    private String englishLabel;
    private String englishName;
    private List<Integer> order;
    private String occurrenceType;
    private String lifetime;
}
