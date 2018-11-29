package com.acidmanic.utilities;

public abstract class ChainableRunnable implements Runnable {

    @Override
    public void run() {
        this.run(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    public abstract void run(Runnable after);

    protected void tryRun(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
