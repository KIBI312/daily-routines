package com.dailyroutines.routines.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false, columnDefinition = "tinytext")
    private String name;
    @Column(columnDefinition = "mediumtext")
    private String description;
    @Column(nullable = false)
    private Integer duration;
    @Column(nullable = false,columnDefinition = "time")
    private Time startTime;
    @Column(columnDefinition = "enum('bodyCare', 'mindCare', 'cleaning', 'education', 'petsAndPlants', 'misc')")
    private Type type;
    @Column(columnDefinition = "enum('coming', 'delayed', 'skipped', 'inProcess', 'done')")
    private Status status;

    private static enum Type {
        bodyCare, mindCare, cleaning, education, petsAndPlants, misc
    }
    private static enum Status {
        coming, delayed, skipped, inProcess, done
    }
}

