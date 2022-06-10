package com.dailyroutines.routines.service;

import java.time.LocalTime;
import java.util.List;

import com.dailyroutines.routines.dto.RoutineDto;
import com.dailyroutines.routines.model.Routine.Routine;
import com.dailyroutines.routines.model.Routine.Schedule;
import com.dailyroutines.routines.model.Routine.TimeRange;
import com.dailyroutines.routines.repository.RoutineRepository;
import com.dailyroutines.routines.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    KeycloakService keycloakService;
    @Autowired
    RoutineService routineService;
    @Autowired
    RoutineRepository routineRepository;

    public void createSchedule() {
        Schedule schedule = new Schedule(keycloakService.getKeycloakUserId());
        scheduleRepository.save(schedule);
    }
    
    public void addToSchedule(TimeRange routineTime) {
        Schedule schedule = scheduleRepository.findById(keycloakService.getKeycloakUserId()).get();
        schedule.getFreeTime().allocateTime(routineTime);
        scheduleRepository.save(schedule);
    }

    public String addRoutine(RoutineDto routineDto) {
        Schedule schedule = scheduleRepository.findById(keycloakService.getKeycloakUserId()).get();
        schedule.getFreeTime().allocateTime(routineDto.getTime());
        schedule.getRoutines().add(routineService.createRoutine(routineDto));
        scheduleRepository.save(schedule);
        return "Success";
    }

    public List<Routine> getRoutines() {
        List<Routine> routines = scheduleRepository.findById(keycloakService.getKeycloakUserId()).get().getRoutines();
        return routines;
    }


}
