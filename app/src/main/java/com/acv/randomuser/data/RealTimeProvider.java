package com.acv.randomuser.data;


public class RealTimeProvider implements TimeProvider {
    @Override
    public Long time() {
        return System.currentTimeMillis();
    }
}
