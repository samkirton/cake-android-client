package com.waracle.waracletest.cache;

import android.graphics.Bitmap;

public class FindImage {
    private final String url;
    private final BitmapCache bitmapCache;

    public String getUrl() {
        return url;
    }

    public FindImage(String url, BitmapCache bitmapCache) {
        this.url = url;
        this.bitmapCache = bitmapCache;
    }

    public boolean exists() {
        return bitmapCache.get(url) != null;
    }

    public Bitmap bitmap() {
        return bitmapCache.get(url);
    }
}