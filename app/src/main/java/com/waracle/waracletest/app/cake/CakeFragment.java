package com.waracle.waracletest.app.cake;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.waracle.waracletest.R;
import com.waracle.waracletest.app.PresenterFragment;
import com.waracle.waracletest.app.data.Cake;
import com.waracle.waracletest.app.ui.DefaultDividerItemDecoration;
import com.waracle.waracletest.async.image.ImageLoader;

import java.util.List;

public class CakeFragment extends PresenterFragment<CakePresenter> implements CakeView {

    private CakeAdapter adapter;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private View errorContainer;
    private TextView errorTitleView;
    private TextView errorBodyView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cake_fragment, container, false);

        adapter = new CakeAdapter(presenter().imageNotFound(), getContext());

        recyclerView = (RecyclerView) rootView.findViewById(R.id.cake_fragment_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DefaultDividerItemDecoration(getActivity()));
        recyclerView.setAdapter(adapter);

        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        errorContainer = rootView.findViewById(R.id.cake_fragment_error_container);
        errorTitleView = (TextView)rootView.findViewById(R.id.cake_fragment_error_title);
        errorBodyView = (TextView)rootView.findViewById(R.id.cake_fragment_error_body);

        Button errorRetry = (Button) rootView.findViewById(R.id.cake_fragment_error_retry);
        errorRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter().loadCakes();
            }
        });

        return rootView;
    }

    public void refresh() {
        presenter().loadCakes();
    }

    @Override
    protected CakePresenter setupPresenter() {
        return new CakePresenter(this, new ImageLoader(this, presenter().imageDownloaded()));
    }

    @Override
    public void startProgress() {
        progressBar.setVisibility(View.VISIBLE);

        errorContainer.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showCakes(List<Cake> cakes) {
        recyclerView.setVisibility(View.VISIBLE);
        adapter.populate(cakes);
    }

    @Override
    public void showError(String title, String body) {
        errorContainer.setVisibility(View.VISIBLE);
        errorTitleView.setText(title);
        errorBodyView.setText(body);
    }
}