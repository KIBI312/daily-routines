package com.dailyroutines.routines.repository;

import java.util.Optional;

import com.dailyroutines.routines.model.Routine.Routine;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoutineRepository extends MongoRepository<Routine, String> {
    Optional<Routine> findByName(String name);
}
