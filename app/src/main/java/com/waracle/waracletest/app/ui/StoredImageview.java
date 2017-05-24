package com.waracle.waracletest.app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.waracle.waracletest.storage.FindImage;
import com.waracle.waracletest.storage.ImageNotFoundCallback;

public class StoredImageView extends ImageView {

    public StoredImageView(Context context) {
        this(context, null);
    }

    public StoredImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StoredImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void load(FindImage findImage, int position, ImageNotFoundCallback imageNotFoundCallback) {
        if (findImage.exists()) {
            setImageBitmap(findImage.bitmap());
        } else {
            imageNotFoundCallback.notFound(findImage.getUrl(), position);
        }
    }
}
