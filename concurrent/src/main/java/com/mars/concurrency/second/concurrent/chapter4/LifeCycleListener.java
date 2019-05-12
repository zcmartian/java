package com.mars.concurrency.second.concurrent.chapter4;


public interface LifeCycleListener {

    void onEvent(ObservableRunnable.RunnableEvent event);
}
