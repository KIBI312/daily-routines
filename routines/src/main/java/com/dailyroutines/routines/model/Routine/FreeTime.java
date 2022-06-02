package com.dailyroutines.routines.model.Routine;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FreeTime {
    
    private List<TimeRange> periods = new ArrayList<TimeRange>();;

    public FreeTime() {
        TimeRange wholeDay = new TimeRange(LocalTime.of(0, 0), LocalTime.of(23, 59));
        periods.add(wholeDay);
    }

}
