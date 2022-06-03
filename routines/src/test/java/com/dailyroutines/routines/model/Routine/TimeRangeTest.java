package com.dailyroutines.routines.model.Routine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeRangeTest {

    TimeRange timeRange;

    @BeforeEach
    void setUp() {
        timeRange = new TimeRange(LocalTime.of(10, 0), LocalTime.of(12, 30));
    }

    @Test
    void testIllegalArgumentExceptionOnConstructor() {
        assertThrows(IllegalArgumentException.class, ()->{
            timeRange = new TimeRange(LocalTime.of(13, 0), LocalTime.of(12, 30));
        });
    }

    @Test
    void testCalculateDuration() {
        assertEquals(Duration.of(150, ChronoUnit.MINUTES), timeRange.calculateDuration());
    }

    @Test
    void testDoesContain() {
        //given time inside TimeRange
        TimeRange time = new TimeRange(LocalTime.of(11, 0), LocalTime.of(11, 30));
        assertTrue(timeRange.doesContain(time));
        //given time equals TimeRange
        time.setStart(LocalTime.of(10, 0));
        time.setEnd(LocalTime.of(12, 30));
        assertTrue(timeRange.doesContain(time));
        //end border of given time outside TimeRange
        time.setStart(LocalTime.of(10, 30));
        time.setEnd(LocalTime.of(13, 30));
        assertFalse(timeRange.doesContain(time));
        //start border of given time outside TimeRange
        time.setStart(LocalTime.of(8, 30));
        time.setEnd(LocalTime.of(11, 30));
        assertFalse(timeRange.doesContain(time));
        //given time outside TimeRange
        time.setStart(LocalTime.of(8, 30));
        time.setEnd(LocalTime.of(13, 30));
        assertFalse(timeRange.doesContain(time));
    }

    @Test
    void testInsertTimeRange() {
        TimeRange time = new TimeRange(LocalTime.of(11, 0), LocalTime.of(11, 30));
        TimeRange time1 = new TimeRange(LocalTime.of(10, 0), LocalTime.of(11, 0));
        TimeRange time3 = new TimeRange(LocalTime.of(11, 30), LocalTime.of(12, 30));
        List<TimeRange> timeList1 = timeRange.insertTimeRange(time);
        List<TimeRange> timeList2 = List.of(time1, time, time3);
        assertEquals(timeList1, timeList2);
    }
}
