package com.dailyroutines.routines.dto;

import com.dailyroutines.routines.model.Routine.Routine.Status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoutineStatusDto {
    
    private String name;
    private Status status;

}
