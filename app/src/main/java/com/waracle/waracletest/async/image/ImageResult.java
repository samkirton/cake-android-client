package com.waracle.waracletest.async.image;

public class ImageResult {

    private final String url;
    private final int position;

    public String getUrl() {
        return url;
    }

    public int getPosition() {
        return position;
    }

    ImageResult(String url, int position) {
        this.url = url;
        this.position = position;
    }
}