package com.waracle.waracletest.storage;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;

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
            File file = new File(context.getFilesDir(), name);
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

            fos.close();

            path = file.getAbsolutePath();

        } catch (Exception ignored) { }
    }
}
