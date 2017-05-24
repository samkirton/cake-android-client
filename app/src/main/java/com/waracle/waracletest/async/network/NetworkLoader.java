package com.waracle.waracletest.async.network;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.waracle.waracletest.network.Load;
import com.waracle.waracletest.network.Response;

import java.net.URL;


class NetworkLoader extends AsyncTaskLoader<NetworkResult> {

    private NetworkResult data;

    private final String url;

    NetworkLoader(String url, Context context) {
        super(context);

        this.url = url;
    }

    @Override
    public NetworkResult loadInBackground() {
        try {
            Response response = new Load(new URL(url)).fetch();
            data = new NetworkResult(new String(response.bytes(), "UTF-8"), response.code());
            return data;
        } catch (Exception e) {
            return new NetworkResult(null, -1);
        }
    }

    @Override
    public void deliverResult(NetworkResult data) {
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