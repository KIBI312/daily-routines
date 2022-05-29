package com.dailyroutines.routines.model.Avatar;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Indicators {

    private Integer healthPoints;
    private Integer water;
    private Integer food;
    private Integer sleep;
    private Integer hygiene;
    
}
