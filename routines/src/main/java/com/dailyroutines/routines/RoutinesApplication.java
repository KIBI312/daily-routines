package com.dailyroutines.routines;

import com.dailyroutines.routines.model.Avatar.Avatar;
import com.dailyroutines.routines.model.Avatar.Experience;
import com.dailyroutines.routines.model.Avatar.Indicators;
import com.dailyroutines.routines.model.Avatar.Stats;
import com.dailyroutines.routines.repository.AvatarRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoutinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutinesApplication.class, args);
	}

}
