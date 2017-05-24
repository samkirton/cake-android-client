package com.waracle.waracletest.storage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class FindImage {

    private final String url;
    private final File file;

    public String getUrl() {
        return url;
    }

    public FindImage(String url, Context context) {
        this.url = url;

        String path = context.getFilesDir().toString();
        String encodedUrl = encodeUrl(url);
        String fullPath = path + "/" + encodedUrl;

        file = new File(fullPath);
    }

    private String encodeUrl(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public boolean exists() {
        return file.exists();
    }

    public Bitmap bitmap() {
        long length = file.length();
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        return bitmap;
    }
}