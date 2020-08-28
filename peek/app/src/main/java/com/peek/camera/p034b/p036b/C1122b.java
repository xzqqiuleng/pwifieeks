package com.peek.camera.p034b.p036b;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bmw.peek2.b.b.b */
public class C1122b extends C1121a {
    public C1122b(ExecutorService executorService) {
        super(executorService);
    }

    public /* bridge */ /* synthetic */ boolean awaitTermination(long j, TimeUnit timeUnit) {
        return super.awaitTermination(j, timeUnit);
    }

    public /* bridge */ /* synthetic */ void execute(Runnable runnable) {
        super.execute(runnable);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        super.shutdown();
    }

    public /* bridge */ /* synthetic */ List invokeAll(Collection collection) {
        return super.invokeAll(collection);
    }

    public /* bridge */ /* synthetic */ List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return super.invokeAll(collection, j, timeUnit);
    }

    public /* bridge */ /* synthetic */ Object invokeAny(Collection collection) {
        return super.invokeAny(collection);
    }

    public /* bridge */ /* synthetic */ Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return super.invokeAny(collection, j, timeUnit);
    }

    public /* bridge */ /* synthetic */ boolean isShutdown() {
        return super.isShutdown();
    }

    public /* bridge */ /* synthetic */ boolean isTerminated() {
        return super.isTerminated();
    }

    public /* bridge */ /* synthetic */ void shutdown() {
        super.shutdown();
    }

    public /* bridge */ /* synthetic */ List shutdownNow() {
        return super.shutdownNow();
    }

    public /* bridge */ /* synthetic */ Future submit(Runnable runnable) {
        return super.submit(runnable);
    }

    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return super.submit(runnable, obj);
    }

    public /* bridge */ /* synthetic */ Future submit(Callable callable) {
        return super.submit(callable);
    }
}
