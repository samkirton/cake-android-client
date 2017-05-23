package com.waracle.waracletest.async;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.waracle.waracletest.network.Load;

import java.net.URL;


class NetworkLoader extends AsyncTaskLoader<Result> {

    private Result data;

    private final String url;

    NetworkLoader(String url, Context context) {
        super(context);

        this.url = url;
    }

    @Override
    public Result loadInBackground() {
        try {
            return new Result(new Load(new URL(url)).fetch(), true);
        } catch (Exception e) {
            return new Result(null, false);
        }
    }

    @Override
    public void deliverResult(Result data) {
        if (!isReset() && isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStartLoading() {
        if (data != null) {
            deliverResult(data);
        }

        if (takeContentChanged() || data == null) {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        onStopLoading();
    }
}