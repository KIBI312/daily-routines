package com.dailyroutines.routines.model.Routine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
@Document
public class Schedule {
    
    @Id
    private String keycloakId;
    private FreeTime freeTime;
    @DocumentReference
    private List<Routine> routines;

    public Schedule(String keycloakId) {
        this.keycloakId = keycloakId;
        this.freeTime = new FreeTime();
        this.routines = new ArrayList<Routine>();
    }
}
