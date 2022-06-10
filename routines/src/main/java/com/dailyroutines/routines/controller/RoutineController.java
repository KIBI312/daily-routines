package com.dailyroutines.routines.controller;


import javax.servlet.http.HttpServletResponse;

import com.dailyroutines.routines.dto.RoutineDto;
import com.dailyroutines.routines.dto.RoutineStatusDto;
import com.dailyroutines.routines.model.Routine.Routine;
import com.dailyroutines.routines.repository.RoutineRepository;
import com.dailyroutines.routines.service.RoutineService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutineController {


    Logger logger = LoggerFactory.getLogger(RoutineController.class);
    
    @Autowired
    RoutineService routineService;
    @Autowired
    RoutineRepository routineRepository;

    @PostMapping(value = "/routine/get", consumes = "application/json", produces = "application/json")
    public Routine getRoutine(@RequestBody String id, HttpServletResponse response) {
        Routine routine = routineRepository.findById(id).get();
        return routine;
    }
}
