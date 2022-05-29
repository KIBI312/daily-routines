package com.dailyroutines.routines.repository;

import com.dailyroutines.routines.model.Avatar.Avatar;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvatarRepository extends MongoRepository<Avatar, String> {
    
}
