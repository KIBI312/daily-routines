package com.dailyroutines.routines.model.Routine;

import com.dailyroutines.routines.dto.RoutineDto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Routine {
    @Id
    private String id;
    private String keycloakId;
    private String name;
    private String description;
    private Category category;
    private TimeRange time;
    private Boolean[] frequency = {false,false,false,false,false,false,false}; //Represents on which days of week action should be repeated going from monday to sunday
    private Status status;
    
    public enum Category {
        education, mealtime, housekeeping, sport, hygiene, family, work, sleep, hobby
    }

    public enum Status {
        coming, inProgress, delayed, cancelled
    }

    public Routine(String keycloakId, RoutineDto routineDto) {
        this.keycloakId = keycloakId;
        this.name = routineDto.getName();
        this.description = routineDto.getDescription();
        this.category = routineDto.getCategory();
        this.time = routineDto.getTime();
        this.frequency = routineDto.getFrequency();
        this.status = routineDto.getStatus();
    }

}
