package com.oddschecker.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class MainBetOffer {
    private Long id;
    private Boolean suspended;
    private Criterion criterion;
    private BetOfferType betOfferType;
    private Long eventId;
    private List<Outcomes> outcomes;
    private List<String> tags;
    private String state;
    private String cashOutStatus;
    private EachWay eachWay;
    private Integer from;
    private Integer to;
    private String description;
    private OddsStats oddsStats;

}
