package com.waracle.waracletest.async.network;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

public class NetworkLoaderCallback implements LoaderManager.LoaderCallbacks<NetworkResult> {
    private final String url;
    private final NetworkCallback callback;
    private final Context context;

    public NetworkLoaderCallback(Context context, String url, NetworkCallback callback) {
        this.callback = callback;
        this.url = url;
        this.context = context;
    }

    @Override
    public Loader<NetworkResult> onCreateLoader(int id, Bundle args) {
        return new NetworkLoader(url, context);
    }

    @Override
    public void onLoadFinished(Loader<NetworkResult> loader, NetworkResult data) {
        callback.done(data);
    }

    @Override
    public void onLoaderReset(Loader<NetworkResult> loader) {

    }
}