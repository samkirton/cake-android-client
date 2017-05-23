package com.waracle.waracletest.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class PresenterFragment<P extends Presenter> extends Fragment
    implements PresenterView {

    private P presenter;

    protected P getPresenter() {
        return presenter;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = setupPresenter();
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        presenter.onStop();
    }

    @Override
    public void startProgress() {

    }

    @Override
    public void hideProgress() {

    }

    protected abstract P setupPresenter();
}