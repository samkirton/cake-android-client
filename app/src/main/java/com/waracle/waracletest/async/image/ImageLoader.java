package com.waracle.waracletest.async.image;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.waracle.waracletest.network.Load;
import com.waracle.waracletest.network.Response;
import com.waracle.waracletest.storage.SaveImage;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {

    private final Context context;
    private final ImageCallback imageCallback;
    private final Set<String> imageUrlTasks = new HashSet<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public ImageLoader(Context context, ImageCallback imageCallback) {
        this.context = context;
        this.imageCallback = imageCallback;
    }

    public void loadImage(final String url, final int position) {
        if (!imageUrlTasks.contains(url)) {
            imageUrlTasks.add(url);

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    downloadImage(url, position);
                    imageUrlTasks.remove(url);
                }
            });
        }
    }

    private void downloadImage(String url, int position) {
        try {
            Load load = new Load(new URL(url));
            Response response = load.fetch();
            BitmapFactory.decodeByteArray(response.bytes(), 0, response.bytes().length);

            SaveImage saveImage = new SaveImage(
                    url,
                    BitmapFactory.decodeByteArray(response.bytes(), 0, response.bytes().length),
                    context
            );

            saveImage.save();

            imageCallback.done(new ImageResult(
                    saveImage.path(),
                    position
            ));

        } catch (Exception ignored) { }
    }
}