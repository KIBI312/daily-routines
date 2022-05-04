package com.dailyroutines.routines.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.TypeErasing;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(36)")
    private String userId;
    @Column(nullable = false, columnDefinition = "tinytext")
    private String name;
    @Column(columnDefinition = "mediumtext")
    private String description;
    @Column(nullable = false)
    private Integer duration;
    @Column(columnDefinition = "time")
    private Time startTime;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('bodyCare', 'mindCare', 'cleaning', 'education', 'petsAndPlants', 'misc') DEFAULT 'misc'")
    private Type type=Type.misc;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('coming', 'delayed', 'skipped', 'inProcess', 'done') DEFAULT 'coming'")
    private Status status=Status.coming;

    public static enum Type {
        bodyCare, mindCare, cleaning, education, petsAndPlants, misc
    }
    private static enum Status {
        coming, delayed, skipped, inProcess, done
    }

    public Routine(String userId, String name, String description, Integer duration, Type type) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.type = type;
    }

}

