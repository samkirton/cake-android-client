package com.waracle.waracletest.app.cake;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.waracle.waracletest.R;
import com.waracle.waracletest.app.data.Cake;

import java.util.List;

class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.CakeViewHolder> {

    private List<Cake> cakes;

    private final LayoutInflater inflater;

    CakeAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    void populate(List<Cake> cakes) {
        this.cakes = cakes;
        notifyDataSetChanged();
    }

    @Override
    public CakeAdapter.CakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CakeViewHolder(inflater.inflate(R.layout.cake_list_item, null));
    }

    @Override
    public void onBindViewHolder(CakeAdapter.CakeViewHolder holder, int position) {
        holder.populate(cakes.get(position));
    }

    @Override
    public int getItemCount() {
        return cakes != null ? cakes.size() : 0;
    }

    static class CakeViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView desc;
        private final ImageView image;

        CakeViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.cake_list_item_title);
            desc = (TextView) itemView.findViewById(R.id.cake_list_item_desc);
            image = (ImageView) itemView.findViewById(R.id.cake_list_item_image);
        }

        void populate(Cake cake) {
            title.setText(cake.getTitle());
            desc.setText(cake.getDesc());
        }
    }
}
