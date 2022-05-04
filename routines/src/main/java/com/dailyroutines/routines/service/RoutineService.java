package com.dailyroutines.routines.service;

import java.security.Principal;

import com.dailyroutines.routines.dto.RoutineDto;
import com.dailyroutines.routines.entity.Routine;
import com.dailyroutines.routines.repository.RoutineRepository;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class RoutineService {
    

    Logger logger = LoggerFactory.getLogger(RoutineService.class);

    @Autowired
    RoutineRepository routineRepository;

    public void createRoutine(RoutineDto routineDto) {
        KeycloakAuthenticationToken authenticationToken = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authenticationToken.getPrincipal();
        KeycloakPrincipal kPrincipal = (KeycloakPrincipal) principal;
        String userId = kPrincipal.getKeycloakSecurityContext().getToken().getSubject(); 
        Routine routine = new Routine(userId, routineDto.getName(), routineDto.getDescription(), routineDto.getDuration(), routineDto.getType());
        routineRepository.save(routine);
    }

}
