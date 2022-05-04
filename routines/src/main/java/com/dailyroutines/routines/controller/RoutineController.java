package com.dailyroutines.routines.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import com.dailyroutines.routines.dto.RoutineDto;
import com.dailyroutines.routines.exception.ErrorMessage;
import com.dailyroutines.routines.service.RoutineService;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RoutineController {
    
    Logger logger = LoggerFactory.getLogger(RoutineService.class);

    @Autowired
    RoutineService routineService;

    @PostMapping(value="/new/routine", consumes = "application/json", produces = "application/json")
    public String createRoutine(@RequestBody RoutineDto routineDto, HttpServletResponse response) {
            routineService.createRoutine(routineDto);
            return "Success";
    }
    
}
