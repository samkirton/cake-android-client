package com.waracle.waracletest.app.cake;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waracle.waracletest.R;
import com.waracle.waracletest.app.data.Cake;
import com.waracle.waracletest.app.ui.StoredImageView;
import com.waracle.waracletest.storage.FindImage;
import com.waracle.waracletest.storage.ImageNotFoundCallback;

import java.util.List;

class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.CakeViewHolder> {

    private List<Cake> cakes;

    private final ImageNotFoundCallback imageNotFoundCallback;
    private final LayoutInflater inflater;

    CakeAdapter(ImageNotFoundCallback imageNotFoundCallback, Context context) {

        this.imageNotFoundCallback = imageNotFoundCallback;

        inflater = LayoutInflater.from(context);
    }

    void populate(List<Cake> cakes) {
        this.cakes = cakes;
        notifyDataSetChanged();
    }

    void imageLoaded(int position) {
        notifyItemChanged(position);
    }

    @Override
    public CakeAdapter.CakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CakeViewHolder(
                inflater.inflate(R.layout.cake_list_item, null),
                imageNotFoundCallback
        );
    }

    @Override
    public void onBindViewHolder(CakeAdapter.CakeViewHolder holder, int position) {
        holder.populate(cakes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return cakes != null ? cakes.size() : 0;
    }

    static class CakeViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView desc;
        private final StoredImageView image;
        private final ImageNotFoundCallback imageNotFoundCallback;

        CakeViewHolder(View itemView, ImageNotFoundCallback imageNotFoundCallback) {
            super(itemView);

            this.imageNotFoundCallback = imageNotFoundCallback;

            title = (TextView) itemView.findViewById(R.id.cake_list_item_title);
            desc = (TextView) itemView.findViewById(R.id.cake_list_item_desc);
            image = (StoredImageView) itemView.findViewById(R.id.cake_list_item_image);
        }

        void populate(Cake cake, int position) {
            title.setText(cake.getTitle());
            desc.setText(cake.getDesc());
            image.load(
                    new FindImage(
                            cake.getImage(),
                            image.getContext()
                    ),
                    position,
                    imageNotFoundCallback
            );
        }
    }
}