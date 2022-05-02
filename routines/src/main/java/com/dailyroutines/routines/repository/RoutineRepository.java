package com.dailyroutines.routines.repository;

import com.dailyroutines.routines.entity.Routine;

import org.springframework.data.repository.CrudRepository;

public interface RoutineRepository extends CrudRepository<Long, Routine> {
    
}
