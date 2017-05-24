package com.waracle.waracletest.storage;

import android.graphics.Bitmap;

public class FindImage {

    private final String url;

    public String getUrl() {
        return url;
    }

    public FindImage(String url) {
        this.url = url;
    }

    public boolean exists() {
        return false;
    }

    public Bitmap bitmap() {
        return null;
    }
}