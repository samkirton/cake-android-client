package com.waracle.waracletest.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.waracle.waracletest.async.Callback;
import com.waracle.waracletest.async.NetworkLoaderCallback;

public abstract class PresenterFragment<P extends Presenter> extends Fragment
    implements PresenterView {

    private P presenter;

    protected P presenter() {
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
    public void networkDelegate(String url, Callback callback) {
        ((DefaultActivity)getContext()).getSupportLoaderManager().restartLoader(0, null,
                new NetworkLoaderCallback(getContext(), url, callback));
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void startProgress() {

    }

    @Override
    public void hideProgress() {

    }

    protected abstract P setupPresenter();
}