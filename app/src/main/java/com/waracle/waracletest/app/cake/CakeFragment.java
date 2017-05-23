package com.waracle.waracletest.app.cake;

import com.waracle.waracletest.app.DefaultActivity;
import com.waracle.waracletest.app.data.CakeList;
import com.waracle.waracletest.async.Callback;
import com.waracle.waracletest.async.NetworkLoaderCallback;
import com.waracle.waracletest.app.PresenterFragment;
import com.waracle.waracletest.async.Result;

import static com.waracle.waracletest.app.data.Api.CAKE_ENDPOINT;

public class CakeFragment extends PresenterFragment<CakePresenter> implements CakeView {

    @Override
    protected CakePresenter setupPresenter() {
        return new CakePresenter(this);
    }

    @Override
    public void showCakes() {

    }

    @Override
    public void onStart() {
        super.onStart();

        ((DefaultActivity)getContext()).getSupportLoaderManager().initLoader(0, null,
                new NetworkLoaderCallback(getContext(), CAKE_ENDPOINT, new Callback() {

            @Override
            public void done(Result result) {
                CakeList cakeList = new CakeList(result.getBody());
            }
        }));
    }
}
