package com.waracle.waracletest.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class BitmapCache extends LruCache<String, Bitmap> {

    public BitmapCache(MemoryLimit memoryLimit) {
        super(memoryLimit.size());
    }

    @Override
    protected int sizeOf(String key, Bitmap bitmap) {
        return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
    }

    public boolean has(String key) {
        return get(key) != null;
    }
}