package com.waracle.waracletest.async.image;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;

import com.waracle.waracletest.cache.BitmapCache;
import com.waracle.waracletest.cache.SaveImage;
import com.waracle.waracletest.network.Load;
import com.waracle.waracletest.network.Response;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.waracle.waracletest.app.DefaultApplication.BITMAP_CACHE;

public class ImageLoader {

    private final Context context;
    private final ImageCallback imageCallback;
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final Handler handler = new Handler();

    public ImageLoader(Context context, ImageCallback imageCallback) {
        this.context = context;
        this.imageCallback = imageCallback;
    }

    public void loadImage(final String url, final int position) {
        if (bitmapCache().has(url)) {
            imageCallback.done(new ImageResult(
                    url,
                    position
            ));
        } else {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    downloadImage(url, position);
                }
            });
        }
    }

    private void downloadImage(final String url, final int position) {
        try {
            Load load = new Load(new URL(url));
            Response response = load.fetch();

            SaveImage saveImage = new SaveImage(
                    url,
                    BitmapFactory.decodeByteArray(response.bytes(), 0, response.bytes().length),
                    bitmapCache()
            );

            saveImage.save();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageCallback.done(new ImageResult(
                            url,
                            position
                    ));
                }
            });
        } catch (Exception ignored) {

        }
    }

    @SuppressWarnings("WrongConstant")
    private BitmapCache bitmapCache() {
        return (BitmapCache) context.getApplicationContext().getSystemService(BITMAP_CACHE);
    }
}