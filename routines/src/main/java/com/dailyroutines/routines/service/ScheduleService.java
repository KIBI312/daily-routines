package com.dailyroutines.routines.service;

import com.dailyroutines.routines.model.Routine.Schedule;
import com.dailyroutines.routines.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    KeycloakService keycloakService;

    public void createSchedule() {
        Schedule schedule = new Schedule(keycloakService.getKeycloakUserId());
        scheduleRepository.save(schedule);
    }

}
