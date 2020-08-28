package com.peek.camera.p034b.p036b;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bmw.peek2.b.b.a */
class C1121a extends AbstractExecutorService {

    /* renamed from: a */
    private final ExecutorService f3090a;

    C1121a(ExecutorService executorService) {
        this.f3090a = executorService;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        try {
            return this.f3090a.awaitTermination(j, timeUnit);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        return false;
    }

    public void execute(Runnable runnable) {
        this.f3090a.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        try {
            return this.f3090a.invokeAll(collection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        try {
            return this.f3090a.invokeAll(collection, j, timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        try {
            return this.f3090a.invokeAny(collection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        try {
            return this.f3090a.invokeAny(collection, j, timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isShutdown() {
        return this.f3090a.isShutdown();
    }

    public boolean isTerminated() {
        return this.f3090a.isTerminated();
    }

    public void shutdown() {
        this.f3090a.shutdown();
    }

    public List<Runnable> shutdownNow() {
        return this.f3090a.shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return this.f3090a.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f3090a.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.f3090a.submit(callable);
    }
}
