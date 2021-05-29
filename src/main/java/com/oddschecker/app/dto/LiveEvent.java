package com.oddschecker.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class LiveEvent {
    private Event event;
    @JsonIgnore
    private LiveData liveData;
    private MainBetOffer mainBetOffer;
}
