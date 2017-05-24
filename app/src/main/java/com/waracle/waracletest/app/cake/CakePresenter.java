package com.waracle.waracletest.app.cake;

import com.waracle.waracletest.R;
import com.waracle.waracletest.app.Presenter;
import com.waracle.waracletest.app.data.CakeList;
import com.waracle.waracletest.async.image.ImageCallback;
import com.waracle.waracletest.async.image.ImageLoader;
import com.waracle.waracletest.async.image.ImageResult;
import com.waracle.waracletest.async.network.NetworkCallback;
import com.waracle.waracletest.async.network.NetworkResult;
import com.waracle.waracletest.storage.FindImage;
import com.waracle.waracletest.storage.ImageNotFoundCallback;

import static com.waracle.waracletest.app.data.Api.CAKE_ENDPOINT;

class CakePresenter extends Presenter<CakeView> {

    private final ImageLoader imageLoader;

    CakePresenter(CakeView view) {
        super(view);

        this.imageLoader = new ImageLoader(
                view.getContext(),
                new ImageCallback() {
                    @Override
                    public void done(ImageResult imageResult) {
                        imageLoaded(imageResult.getPosition());
                    }
                }
        );
    }

    @Override
    protected void start() {
        loadCakes();
    }

    void loadCakes() {
        view().startProgress();

        view().networkDelegate(CAKE_ENDPOINT, cakesResponse());
    }

    private NetworkCallback cakesResponse() {
        return new NetworkCallback() {
            @Override
            public void done(NetworkResult result) {
                if (result.success()) {
                    cakesSuccess(new CakeList(result.getBody()));
                } else {
                    cakesFailure();
                }
            }
        };
    }

    ImageNotFoundCallback imageNotFound() {
        return new ImageNotFoundCallback() {
            @Override
            public void notFound(String url, int position) {
                imageLoader.loadImage(url, position);
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

    private void imageLoaded(int position) {
        view().imageLoadedAtPosition(position);
    }

    @Override
    protected void stop() {

    }
}