package com.dailyroutines.routines.service;

import com.dailyroutines.routines.model.Avatar.Avatar;
import com.dailyroutines.routines.model.Avatar.Experience;
import com.dailyroutines.routines.model.Avatar.Indicators;
import com.dailyroutines.routines.model.Avatar.Stats;
import com.dailyroutines.routines.repository.AvatarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {
    
    @Autowired
    KeycloakService keycloakService;
    @Autowired
    AvatarRepository avatarRepository;

    public void avatarInit() {
        Experience experience = new Experience(1,0);
		Indicators indicators = new Indicators(100, 100, 100, 100, 100);
		Stats stats = new Stats(0, 0, 0, 0, 0, 0);
		Avatar avatar = new Avatar(keycloakService.getKeycloakUserId(), "PicturePath", experience, indicators, stats);
		avatarRepository.save(avatar);
    }

}
