package com.example.chaizexu.tinnews.save.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.chaizexu.tinnews.R;
import com.example.chaizexu.tinnews.common.BaseViewModel;
import com.squareup.picasso.Picasso;

/**
 * Created by chai on 10/11/18.
 */

public class ImageViewModel extends BaseViewModel<ImageViewModel.ImageViewModelViewHolder> {

    private final String uri;
    public ImageViewModel(String uri) {
        super(R.layout.image_layout);
        this.uri = uri;
    }

    @Override
    public ImageViewModelViewHolder createItemViewHolder(View view) {
        return new ImageViewModelViewHolder(view);
    }

    @Override
    public void bindViewHolder(ImageViewModelViewHolder holder) {
        Picasso.get().load(uri).into(holder.image);
    }

    static class ImageViewModelViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageViewModelViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}

