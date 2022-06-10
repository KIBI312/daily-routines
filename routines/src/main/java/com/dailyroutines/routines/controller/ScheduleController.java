package com.dailyroutines.routines.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dailyroutines.routines.dto.RoutineDto;
import com.dailyroutines.routines.model.Routine.Routine;
import com.dailyroutines.routines.repository.ScheduleRepository;
import com.dailyroutines.routines.service.ScheduleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    Logger logger = LoggerFactory.getLogger(ScheduleController.class);

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ScheduleRepository scheduleRepository;


    @GetMapping(value="/schedule/init", produces = "application/json")
    public String initializeSchdule(){
        scheduleService.createSchedule();
        return "Success";
    }

    @GetMapping(value="/schedule/getRoutines", produces = "application/json")
    public List<Routine> addRoutine(HttpServletResponse response){
        logger.error("/getRoutines request");
        return scheduleService.getRoutines();
    }
    
    @PostMapping(value = "/schedule/addRoutine", consumes = "application/json", produces = "application/json")
    public String createRoutine(@RequestBody RoutineDto routineDto, HttpServletResponse response) {
        return scheduleService.addRoutine(routineDto);
    }



}
