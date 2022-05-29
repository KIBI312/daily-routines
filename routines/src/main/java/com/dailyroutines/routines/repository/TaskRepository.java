package com.dailyroutines.routines.repository;

import com.dailyroutines.routines.model.Task.Task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
    
}
