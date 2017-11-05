package com.acv.randomuser.executor;

import java.util.concurrent.ThreadFactory;

public class UseCaseOutputThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "InteractorInvoker" + r.toString());
    }
}
