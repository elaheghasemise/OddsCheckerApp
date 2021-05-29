package com.oddschecker.app.dto;

import lombok.Data;

@Data
public class OddsStats {
    private Boolean unexpectedOddsTrend;
    private Long outcomeId;
    private Integer startingOdds;
    private String startingOddsFractional;
    private String startingOddsAmerican;
}
