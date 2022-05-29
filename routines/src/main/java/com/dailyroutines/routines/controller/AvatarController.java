package com.dailyroutines.routines.controller;

import com.dailyroutines.routines.service.AvatarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvatarController {
    
    @Autowired
    AvatarService avatarService;

    @GetMapping(value="/init/avatar", produces = "application/json")
    public String initializeAvatar(){
        avatarService.avatarInit();
        return "Success";
    }

}
