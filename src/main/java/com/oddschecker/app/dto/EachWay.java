package com.oddschecker.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class EachWay {
    private Integer fractionMilli;
    private String terms;
    private Integer placeLimit;
    private List<String> tags;
}
