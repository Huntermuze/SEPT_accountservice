package com.septgroup.accountservice.doctor.dto;

import java.util.Date;

public class TimeRange {
    private final Date lowerBound;
    private final Date upperBound;

    public TimeRange(Date lowerBound, Date upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Date getLowerBound() {
        return lowerBound;
    }

    public Date getUpperBound() {
        return upperBound;
    }
}
