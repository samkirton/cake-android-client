package com.waracle.waracletest.app.cake.api;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CakeList {

    private final List<Cake> cakes;

    public List<Cake> getCakes() {
        return cakes;
    }

    public CakeList(String string)  {

        cakes = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(string);

            for (int i = 0; i < array.length(); i++) {
                Cake cake = new Cake(array.getJSONObject(i));
                cakes.add(cake);
            }
        } catch (JSONException ignored) {

        }
    }
}
