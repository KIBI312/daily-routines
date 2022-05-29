package com.dailyroutines.routines.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoutineDto {
    
    private String name;
    private String description;
    private Category category;
    private String startTime;
    private String finishTime;
    private Boolean[] frequency = {false,false,false,false,false,false,false}; //Represents on which days of week action should be repeated going from monday to sunday

    public enum Category {
        education, mealtime, housekeeping, sport, hygiene, family, work, sleep
    }

}
