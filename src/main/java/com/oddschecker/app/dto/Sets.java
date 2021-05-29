package com.oddschecker.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class Sets {
    private List<Integer> home;
    private List<Integer> away;
    private Boolean homeServe;
}
