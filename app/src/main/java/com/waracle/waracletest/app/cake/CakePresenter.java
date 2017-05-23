package com.waracle.waracletest.app.cake;

import com.waracle.waracletest.R;
import com.waracle.waracletest.app.Presenter;
import com.waracle.waracletest.app.data.CakeList;
import com.waracle.waracletest.async.Callback;
import com.waracle.waracletest.async.Result;

class CakePresenter extends Presenter<CakeView> {

    CakePresenter(CakeView view) {
        super(view);
    }

    @Override
    protected void start() {
        loadCakes();
    }

    @Override
    protected void stop() {

    }

    void loadCakes() {
        view().startProgress();

        String CAKE_ENDPOINT = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json";
        view().networkDelegate(CAKE_ENDPOINT, cakesResponse());
    }

    private Callback cakesResponse() {
        return new Callback() {
            @Override
            public void done(Result result) {
                if (result.success()) {
                    cakesSuccess(new CakeList(result.getBody()));
                } else {
                    cakesFailure();
                }
            }
        };
    }

    private void cakesSuccess(CakeList cakeList) {

        view().hideProgress();

        view().showCakes(cakeList.getCakes());
    }

    private void cakesFailure() {

        view().hideProgress();

        view().showError(
                view().getContext().getString(R.string.app_error_title_sorry),
                view().getContext().getString(R.string.cake_error_body)
        );
    }
}