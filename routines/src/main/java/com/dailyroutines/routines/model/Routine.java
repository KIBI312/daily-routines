package com.dailyroutines.routines.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Routine {
    @Id
    private String id;
    private String keycloakId;
    private String name;
    private String description;
    private Category category;
    private String startTime;
    private String finishTime;
    private Boolean[] frequency = {false,false,false,false,false,false,false}; //Represents on which days of week action should be repeated going from monday to sunday
    private Status status;
    
    public enum Category {
        education, mealtime, housekeeping, sport, hygiene, family, work, sleep
    }

    public enum Status {
        coming, inProgress, delayed, cancelled
    }
}
