package com.dailyroutines.routines.model.Routine;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FreeTime {
    
    private List<TimeRange> periods = new ArrayList<TimeRange>();

    public FreeTime() {
        TimeRange wholeDay = new TimeRange(LocalTime.of(0, 0), LocalTime.of(23, 59));
        periods.add(wholeDay);
    }

    public void allocateTime(TimeRange routineTime) {
        TimeRange period = periods.stream()
                .filter(freeTime -> freeTime.doesContain(routineTime)).findFirst().get();
        int indexOf = this.periods.indexOf(period);
        List<TimeRange> replacement = period.insertTimeRange(routineTime);
        this.periods.remove(period);
        this.periods.addAll(indexOf, replacement);
    }

    public void unallocateTime() {

    }

}
