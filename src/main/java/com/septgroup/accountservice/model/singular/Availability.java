package com.septgroup.accountservice.model.singular;

import java.util.Arrays;

public class Availability {
    private final TimeRange[] daysOfWeek;

    public Availability() {
        this.daysOfWeek = new TimeRange[7];
    }

    public void setMondayAvailability(TimeRange timeRange) {
        daysOfWeek[0] = timeRange;
    }

    public void setTuesdayAvailability(TimeRange timeRange) {
        daysOfWeek[1] = timeRange;
    }

    public void setWednesdayAvailability(TimeRange timeRange) {
        daysOfWeek[2] = timeRange;
    }

    public void setThursdayAvailability(TimeRange timeRange) {
        daysOfWeek[3] = timeRange;
    }

    public void setFridayAvailability(TimeRange timeRange) {
        daysOfWeek[4] = timeRange;
    }

    public void setSaturdayAvailability(TimeRange timeRange) {
        daysOfWeek[5] = timeRange;
    }

    public void setSundayAvailability(TimeRange timeRange) {
        daysOfWeek[6] = timeRange;
    }

    public TimeRange[] getAvailability() {
        return Arrays.copyOf(daysOfWeek, 7);
    }
}
