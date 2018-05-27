package com.reviewmobileapps.scrollviewlib.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reviewmobileapps.scrollviewlib.ScrollViewConfig;
import com.reviewmobileapps.scrollviewlib.R;
import com.reviewmobileapps.scrollviewlib.items.ThumbnailWithTitleCardItem;

/**
 * This presenter specify how to inflate view for a thumbnail card with title.
 * It also specify how to update data from a {@link ThumbnailWithTitleCardItem} to view.
 */
public class ThumbnailWithTitleCardPresenter implements Presenter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(Context context, ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_thumbnail_with_title_card, parent, false);
        return new ItemViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ScrollViewConfig itemConfig, Object item) {
        ThumbnailWithTitleCardItem thumbnailCardItem = (ThumbnailWithTitleCardItem) item;
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        ImageView image = itemViewHolder.mImage;
        image.setImageResource(thumbnailCardItem.getBackgroundResource());

        TextView textView = itemViewHolder.mTitle;
        textView.setText(thumbnailCardItem.getTitleResource());
        textView.setTextColor(itemConfig.getItemTextColor());
        textView.setTextSize(itemConfig.getItemTextSize());

        View root = itemViewHolder.itemView;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)root.getLayoutParams();
        layoutParams.width = itemConfig.getItemWidth();
        layoutParams.height = itemConfig.getItemHeight();
        layoutParams.setMargins(itemConfig.getItemMarginLeft(), itemConfig.getItemMarginTop()
                , itemConfig.getItemMarginRight(), itemConfig.getItemMarginBottom());
        root.setLayoutParams(layoutParams);
        root.setSelected(thumbnailCardItem.isSelected());
    }

    @Override
    public void onUnbindViewHolder() {
        // Do nothing.
    }

    private static class ItemViewHolder extends ScrollViewHolder {

        ImageView mImage;

        TextView mTitle;

        ItemViewHolder(View view, int viewType) {
            super(view, viewType);
            mImage = (ImageView) view.findViewById(R.id.img_thumbnail);
            mTitle = (TextView) view.findViewById(R.id.txt_title);
        }
    }
}
