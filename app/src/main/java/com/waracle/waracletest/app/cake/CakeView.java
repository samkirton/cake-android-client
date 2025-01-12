package com.waracle.waracletest.app.cake;

import com.waracle.waracletest.app.PresenterView;
import com.waracle.waracletest.app.cake.api.Cake;

import java.util.List;

interface CakeView extends PresenterView {

    void showCakes(List<Cake> cakes);

    void showError(String title, String body);

    void imageLoadedAtPosition(int position);
}