package com.dailyroutines.routines.model.Avatar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document   
public class Avatar {
    @Id
    private String keycloakId;
    private String avatarPicture;
    private Experience experience;
    private Indicators indicators;
    private Stats stats;

    public Avatar(String keycloakId, String avatarPicture, Experience experience, Indicators indicators, Stats stats) {
        this.keycloakId = keycloakId;
        this.avatarPicture = avatarPicture;
        this.experience = experience;
        this.indicators = indicators;
        this.stats = stats;
    }
}
