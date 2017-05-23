package com.waracle.waracletest.app;

public abstract class Presenter<V extends PresenterView> {

    private V view;

    public V view() {
        return view;
    }

    public Presenter(V view) {
        this.view = view;
    }

    void onStart() {
        start();
    }

    void onStop() {
        stop();
    }

    protected abstract void start();

    protected abstract void stop();
}