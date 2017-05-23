package com.waracle.waracletest.app.ui;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;

import com.waracle.waracletest.R;

public class DefaultDividerItemDecoration extends DividerItemDecoration {

    @SuppressWarnings("deprecation")
    public DefaultDividerItemDecoration(Context context) {
        super(context, VERTICAL);

        setDrawable(context.getResources().getDrawable(R.drawable.app_divider));
    }
}
