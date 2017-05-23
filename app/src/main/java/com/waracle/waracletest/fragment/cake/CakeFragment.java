package com.waracle.waracletest.fragment.cake;

import com.waracle.waracletest.fragment.PresenterFragment;

public class CakeFragment extends PresenterFragment<CakePresenter> implements CakeView {

    @Override
    protected CakePresenter setupPresenter() {
        return new CakePresenter(this);
    }

    @Override
    public void showCakes() {

    }
}
