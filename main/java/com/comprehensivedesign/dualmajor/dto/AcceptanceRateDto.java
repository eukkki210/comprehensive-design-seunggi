package com.comprehensivedesign.dualmajor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcceptanceRateDto {
    private int id;
    private String name;
    private int applyNum;
    private int totalNum;
    private double avgGpa;

}
