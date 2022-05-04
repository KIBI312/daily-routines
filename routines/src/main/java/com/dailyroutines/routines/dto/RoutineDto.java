package com.dailyroutines.routines.dto;
import com.dailyroutines.routines.entity.Routine.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoutineDto {

    private String name;
    private String description;
    private Integer duration;
    private Type type;

}
