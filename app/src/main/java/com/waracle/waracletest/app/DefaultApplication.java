package com.waracle.waracletest.app;

import android.app.Application;

import com.waracle.waracletest.cache.BitmapCache;
import com.waracle.waracletest.cache.MemoryLimit;

public class DefaultApplication extends Application {

    public static final String BITMAP_CACHE = "BITMAP_CACHE";

    private BitmapCache bitmapCache;

    @Override
    public void onCreate() {
        super.onCreate();

        bitmapCache = new BitmapCache(new MemoryLimit());
    }

    @Override
    public Object getSystemService(String name) {
        if (name.equals(BITMAP_CACHE)) {
            return bitmapCache;
        } else {
            return super.getSystemService(name);
        }
    }
}