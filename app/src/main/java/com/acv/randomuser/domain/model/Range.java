package com.acv.randomuser.domain.model;

import java.io.Serializable;

public class Range implements Serializable {
    private int init;
    private int end;

    private int increment;

    private Range(int init, int end, int increment) {
        this.init = init;
        this.end = end;
        this.increment = increment;
    }

    public static Range create(int init, int end, int increment){
        return new Range(init, end, increment);
    }

    public int getInit() {
        return init;
    }

    public int getEnd() {
        return end;
    }

    public boolean isMinorThanInit(int other){
        return init >= other;
    }

    public boolean isMinorThanEnd(int other) {
        return other < end;
    }

    public Range increment() {
        return create(end, end += increment, increment);
    }
}
