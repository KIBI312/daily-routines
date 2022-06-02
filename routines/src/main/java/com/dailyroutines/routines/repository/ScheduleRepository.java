package com.dailyroutines.routines.repository;

import com.dailyroutines.routines.model.Routine.Schedule;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    
}
