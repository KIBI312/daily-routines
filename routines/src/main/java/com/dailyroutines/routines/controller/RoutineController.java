package com.dailyroutines.routines.controller;

import java.time.LocalTime;

import javax.servlet.http.HttpServletResponse;

import com.dailyroutines.routines.dto.RoutineDto;
import com.dailyroutines.routines.dto.RoutineStatusDto;
import com.dailyroutines.routines.model.Routine.Routine;
import com.dailyroutines.routines.model.Routine.TimeRange;
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

    @PostMapping(value = "/routine/create", consumes = "application/json", produces = "application/json")
    public String createRoutine(@RequestBody RoutineDto routineDto, HttpServletResponse response) {
        try {
            
            return routineService.createRoutine(routineDto);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping(value = "/routine/update", consumes = "application/json", produces = "application/json")
    public String updateRoutineStatus(@RequestBody RoutineStatusDto routineStatusDto, HttpServletResponse response) {
        return routineService.updateStatus(routineStatusDto);
    }

    @PostMapping(value = "/routine/get", consumes = "application/json", produces = "application/json")
    public Routine getRoutine(@RequestBody String id, HttpServletResponse response) {
        logger.error(id);
        TimeRange time = new TimeRange(LocalTime.of(11, 0), LocalTime.of(13,0));
        Routine routine = routineRepository.findById(id).get();
        logger.error(routine.getTime().calculateDuration().toString());
        logger.error(routine.getTime().doesContain(time).toString());
        return routine;
    }
}
