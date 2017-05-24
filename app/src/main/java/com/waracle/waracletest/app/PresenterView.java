package com.waracle.waracletest.app;

import android.content.Context;

import com.waracle.waracletest.async.network.NetworkCallback;

public interface PresenterView {

    void networkDelegate(String url, NetworkCallback callback);

    Context getContext();

    void startProgress();

    void hideProgress();
}
