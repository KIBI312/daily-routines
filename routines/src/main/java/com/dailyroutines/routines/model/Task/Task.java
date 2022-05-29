package com.dailyroutines.routines.model.Task;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Task {
    
    @Id
    private String id;
    private String name;
    private String description;
    private Date date;
    private Tag tag;

}
