package com.dailyroutines.routines.controller;

import com.dailyroutines.routines.service.ScheduleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping(value="/schedule/init", produces = "application/json")
    public String initializeSchdule(){
        scheduleService.createSchedule();
        return "Success";
    }

}
