package com.waracle.waracletest.async;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

public class NetworkLoaderCallback implements LoaderManager.LoaderCallbacks<Result> {
    private final String url;
    private final Callback callback;
    private final Context context;

    public NetworkLoaderCallback(Context context, String url, Callback callback) {
        this.callback = callback;
        this.url = url;
        this.context = context;
    }

    @Override
    public Loader<Result> onCreateLoader(int id, Bundle args) {
        return new NetworkLoader(url, context);
    }

    @Override
    public void onLoadFinished(Loader<Result> loader, Result data) {
        callback.done(data);
    }

    @Override
    public void onLoaderReset(Loader<Result> loader) {

    }
}