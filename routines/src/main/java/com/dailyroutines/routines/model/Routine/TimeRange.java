package com.dailyroutines.routines.model.Routine;

import java.time.Duration;
import java.time.LocalTime;

import lombok.Data;

@Data
public class TimeRange {
    
    private LocalTime start;
    private LocalTime end;

    public TimeRange(LocalTime start, LocalTime end){
        if(start.isAfter(end)) {
            throw new IllegalArgumentException("Start time cannot be greater than end time");
        }
        this.start = start;
        this.end = end;
    }

    public Duration calculateDuration() {
        return Duration.between(this.start, this.end);
    }

    public Boolean doesContain(TimeRange time) {
        if(time.getStart().compareTo(this.start)>=0 && time.getEnd().compareTo(this.end)<=0) {
            return true;
        }
        return false;
    }

}
