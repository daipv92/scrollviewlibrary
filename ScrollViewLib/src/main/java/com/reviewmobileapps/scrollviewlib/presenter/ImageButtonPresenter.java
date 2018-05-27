package com.reviewmobileapps.scrollviewlib.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.reviewmobileapps.scrollviewlib.ScrollViewConfig;
import com.reviewmobileapps.scrollviewlib.R;
import com.reviewmobileapps.scrollviewlib.items.ImageButtonItem;

/**
 * This presenter specify how to inflate view for an image button item.
 * It also specify how to update data from a {@link ImageButtonItem} to view.
 */
public class ImageButtonPresenter implements Presenter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(Context context, ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_image_button_card, parent, false);
        return new ItemViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ScrollViewConfig itemConfig, Object item) {
        ImageButtonItem imageButtonItem = (ImageButtonItem) item;
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        ImageButton imageButton = itemViewHolder.mImageButton;
        imageButton.setImageResource(imageButtonItem.getBackgroundResource());
        imageButton.setSelected(imageButtonItem.isSelected());
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        layoutParams.width = itemConfig.getItemWidth();
        layoutParams.height = itemConfig.getItemHeight();
        imageButton.setLayoutParams(layoutParams);
    }

    @Override
    public void onUnbindViewHolder() {
        // Do nothing.
    }

    private static class ItemViewHolder extends ScrollViewHolder {

        ImageButton mImageButton;

        ItemViewHolder(View view, int viewType) {
            super(view, viewType);
            mImageButton = (ImageButton) view.findViewById(R.id.img_horizontal_item);
        }
    }
}
