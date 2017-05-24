package com.waracle.waracletest.cache;

import android.graphics.Bitmap;

public class SaveImage {
    private final String name;
    private final Bitmap bitmap;
    private final BitmapCache bitmapCache;

    public SaveImage(String name, Bitmap bitmap, BitmapCache bitmapCache) {
        this.name = name;
        this.bitmap = bitmap;
        this.bitmapCache = bitmapCache;
    }

    public void save() {
        if (!bitmapCache.has(name)) {
            bitmapCache.put(name, bitmap);
        }
    }
}


