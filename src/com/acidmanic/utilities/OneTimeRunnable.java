package com.acidmanic.utilities;

public class OneTimeRunnable extends ChainableRunnable {

    private boolean isRunned = false;
    private boolean fireOnCompletionEachCall = false;
    private Runnable runnable;

    public OneTimeRunnable(Runnable runnable) {
        this(runnable, false);
    }

    public OneTimeRunnable(Runnable runnable, boolean fireOnCompletionEachCall) {
        this.fireOnCompletionEachCall = fireOnCompletionEachCall;
        this.runnable = runnable;
        this.isRunned = false;
    }

    @Override
    public void run(Runnable after) {
        if (this.isRunned) {
            if (this.fireOnCompletionEachCall) {
                tryRun(after);
            }
        } else {
            this.isRunned = true;
            if (this.runnable instanceof ChainableRunnable) {
                ((ChainableRunnable) this.runnable).run(after);
            } else {
                tryRun(this.runnable);
                tryRun(after);
            }
        }
    }


    public boolean isFireOnCompletionEachCall() {
        return fireOnCompletionEachCall;
    }

    public void setFireOnCompletionEachCall(boolean fireOnCompletionEachCall) {
        this.fireOnCompletionEachCall = fireOnCompletionEachCall;
    }
}
