package com.dailyroutines.routines.model.Routine;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class TimeRange {
    
    private LocalTime start;
    private LocalTime end;

    public TimeRange(LocalTime start, LocalTime end){
        if(start.isAfter(end)) {
            throw new IllegalArgumentException("Start time cannot be greater than end time");
        }else if(start.equals(end)) {
            throw new IllegalArgumentException("Start time cannot equals end time");
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

    public List<TimeRange> insertTimeRange(TimeRange timeRange) {
        try {
            TimeRange beforeInsertion = new TimeRange(this.start, timeRange.getStart());
            TimeRange afterInsertion = new TimeRange(timeRange.getEnd(), this.end);
            List<TimeRange> result = List.of(beforeInsertion, afterInsertion);
            return result;            
        } catch (IllegalArgumentException e) {
            List<TimeRange> result = List.of(); 
            if(this.start.equals(timeRange.getStart()) && this.end.equals(timeRange.getEnd())){
                return result;
            }
            else if(this.start.equals(timeRange.getStart())) {
                TimeRange afterInsertion = new TimeRange(timeRange.getEnd(), this.end);
                result = List.of(afterInsertion);
                return result; 
            }
            TimeRange beforeInsertion = new TimeRange(this.start, timeRange.getStart());
            result = List.of(beforeInsertion);
            return result; 
        }
    }
}
