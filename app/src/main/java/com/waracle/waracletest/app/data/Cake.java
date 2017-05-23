package com.waracle.waracletest.app.data;

import org.json.JSONException;
import org.json.JSONObject;

public class Cake {
    private final String title;
    private final String desc;
    private final String image;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }

    public Cake(JSONObject json) throws JSONException {
        title = json.has("title") ? json.getString("title") : null;
        desc = json.has("desc") ? json.getString("desc") : null;
        image = json.has("image") ? json.getString("image") : null;
    }
}