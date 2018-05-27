package com.reviewmobileapps.scrollviewlib.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Custom ViewHolder for {@link com.reviewmobileapps.scrollviewlib.CustomScrollView}
 */
public class ScrollViewHolder extends RecyclerView.ViewHolder {

    private final int mViewType;

    public ScrollViewHolder(View itemView, int viewType) {
        super(itemView);
        mViewType = viewType;
    }

    public int getViewType() {
        return mViewType;
    }
}
