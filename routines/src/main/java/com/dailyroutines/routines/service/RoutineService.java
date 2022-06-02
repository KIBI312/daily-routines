package com.dailyroutines.routines.service;

import com.dailyroutines.routines.dto.RoutineDto;
import com.dailyroutines.routines.dto.RoutineStatusDto;
import com.dailyroutines.routines.model.Routine.Routine;
import com.dailyroutines.routines.repository.RoutineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineService {
    
    @Autowired
    KeycloakService keycloakService;
    @Autowired
    RoutineRepository routineRepository;
    
    public String createRoutine(RoutineDto routineDto) {
        Routine routine = new Routine(keycloakService.getKeycloakUserId(), routineDto);
        routineRepository.save(routine);
        return "Success";
    }

    public String updateStatus(RoutineStatusDto routineStatusDto) {
        routineRepository.findByName("test").get();
        // routine.setStatus(routineStatusDto.getStatus());
        // routineRepository.save(routine);
        return "Success";
    }

}
