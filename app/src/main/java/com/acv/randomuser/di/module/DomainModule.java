package com.acv.randomuser.di.module;


import com.acv.randomuser.BuildConfig;
import com.acv.randomuser.executor.LogExceptionHandler;
import com.acv.randomuser.executor.UseCaseFutureInvoker;
import com.acv.randomuser.executor.UseCaseInvoker;
import com.acv.randomuser.executor.UseCaseOutputThreadFactory;
import com.acv.randomuser.executor.UseCasePriorityBlockingQueue;
import com.acv.randomuser.executor.priority.PriorizableThreadPoolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    @Singleton
    UseCaseInvoker provideUseCaseInvoker(
            ExecutorService executor,
            LogExceptionHandler logExceptionHandler
    ) {
        return new UseCaseFutureInvoker(executor, logExceptionHandler);
    }

    @Provides
    @Singleton
    ExecutorService provideExecutor(
            ThreadFactory threadFactory,
            BlockingQueue<Runnable> blockingQueue
    ) {
        return new PriorizableThreadPoolExecutor(
                BuildConfig.CONCURRENT_INTERACTORS,
                BuildConfig.CONCURRENT_INTERACTORS,
                0L,
                TimeUnit.MILLISECONDS,
                blockingQueue,
                threadFactory);
    }

    @Provides
    @Singleton
    public BlockingQueue<Runnable> provideBlockingQueue() {
        return new UseCasePriorityBlockingQueue(100);
    }

    @Provides
    @Singleton
    ThreadFactory provideThreadFactory() {
        return new UseCaseOutputThreadFactory();
    }

    @Provides
    @Singleton
    LogExceptionHandler provideLogExceptionHandler() {
        return new LogExceptionHandler();
    }


}
