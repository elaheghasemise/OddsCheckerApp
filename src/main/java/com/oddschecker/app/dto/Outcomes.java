package com.oddschecker.app.dto;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Outcomes {
    private Long id;
    private String label;
    private String englishLabel;
    private Integer odds;
    private String participant;
    private String type;
    private Long betOfferId;
    private String changedDate;
    private Long participantId;
    private String oddsFractional;
    private String oddsAmerican;
    private String status;
    private String cashOutStatus;
    private List<Integer> prevOdds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outcomes outcomes = (Outcomes) o;
        return label.equals(outcomes.label) &&
                odds.equals(outcomes.odds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, odds);
    }


}
