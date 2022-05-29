package com.dailyroutines.routines.repository;

import com.dailyroutines.routines.model.Routine;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoutineRepository extends MongoRepository<Routine, String> {
    
}
