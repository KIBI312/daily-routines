package com.dailyroutines.routines.dto;

import com.dailyroutines.routines.model.Routine.TimeRange;
import com.dailyroutines.routines.model.Routine.Routine.Category;
import com.dailyroutines.routines.model.Routine.Routine.Status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoutineDto {
    
    private String name;
    private String description;
    private Category category;
    private TimeRange time;
    private Boolean[] frequency = {false,false,false,false,false,false,false}; //Represents on which days of week action should be repeated going from monday to sunday
    private Status status;
    
}
