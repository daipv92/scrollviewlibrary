package com.reviewmobileapps.scrollviewlib.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.reviewmobileapps.scrollviewlib.ScrollViewConfig;

/**
 * Each item in custom scroll view is a view.
 * To separate data and view, we used Presenter as view creator.
 * Therefore, this interface define API which relate to view.
 */
public interface Presenter {

    /**
     * Inflate a view to parent.
     * Then, save them in ViewHolder to improve performance.
     * @param context
     * @param parent
     * @param viewType
     * @return
     */
    RecyclerView.ViewHolder onCreateViewHolder(Context context, ViewGroup parent, int viewType);

    /**
     * Update data to view through item and holder.
     * @param holder
     * @param itemConfig
     * @param item
     */
    void onBindViewHolder(RecyclerView.ViewHolder holder, ScrollViewConfig itemConfig, Object item);

    /**
     * Release resource if need.
     */
    void onUnbindViewHolder();
}
