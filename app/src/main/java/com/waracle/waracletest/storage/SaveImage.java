package com.waracle.waracletest.storage;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;

public class SaveImage {
    private final String name;
    private final Bitmap bitmap;
    private final Context context;

    private String path;

    public String path() {
        return path;
    }

    public SaveImage(String name, Bitmap bitmap, Context context) {
        this.name = name;
        this.bitmap = bitmap;
        this.context = context;
    }

    public void save() {

        try {
            String encodedUrl = URLEncoder.encode(name, "UTF-8");
            File file = new File(context.getFilesDir(), encodedUrl);
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

            fos.close();

            path = file.getAbsolutePath();

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
