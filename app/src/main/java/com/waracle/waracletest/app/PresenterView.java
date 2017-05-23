package com.waracle.waracletest.app;

import android.content.Context;

import com.waracle.waracletest.async.Callback;

public interface PresenterView {

    void networkDelegate(String url, Callback callback);

    Context getContext();

    void startProgress();

    void hideProgress();
}
