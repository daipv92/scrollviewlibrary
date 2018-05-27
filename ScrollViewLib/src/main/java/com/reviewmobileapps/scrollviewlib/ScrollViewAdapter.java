package com.reviewmobileapps.scrollviewlib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.reviewmobileapps.scrollviewlib.items.IScrollViewItem;
import com.reviewmobileapps.scrollviewlib.items.SelectableItem;
import com.reviewmobileapps.scrollviewlib.presenter.ScrollViewHolder;
import com.reviewmobileapps.scrollviewlib.presenter.Presenter;
import com.reviewmobileapps.scrollviewlib.selector.PresenterSelector;

import java.util.ArrayList;
import java.util.List;

/**
 * The Adapter handle how to inflate view for {@link CustomScrollView}.
 */
public class ScrollViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /*
     * Implement this interface to listen to click event on each item card.
     */
    public interface IOnItemClickListener {

        /**
         * This callback is called when users click on any item card.
         * @param item selected item.
         */
        void onClicked(IScrollViewItem item);
    }

    private final List<IScrollViewItem> mItemList = new ArrayList<>();

    private final Context mContext;

    private final ScrollViewConfig mItemConfig;

    private final IOnItemClickListener mOnItemClickListener;

    private final PresenterSelector mPresenterSelector;

    /**
     * Constructor.
     * @param context
     * @param itemConfig
     * @param selector
     */
    public ScrollViewAdapter(Context context, ScrollViewConfig itemConfig, PresenterSelector selector, IOnItemClickListener listener) {
        if (context == null || itemConfig == null || selector == null || listener == null) {
            throw new IllegalArgumentException("The argument is in-valid");
        }
        mContext = context;
        mItemConfig = itemConfig;
        mPresenterSelector = selector;
        mOnItemClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Presenter presenter = mPresenterSelector.getPresenter(viewType);
        return presenter.onCreateViewHolder(mContext, parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ScrollViewHolder scrollViewHolder = (ScrollViewHolder) holder;
        Presenter presenter = mPresenterSelector.getPresenter(scrollViewHolder.getViewType());
        final IScrollViewItem item = mItemList.get(position);

        presenter.onBindViewHolder(scrollViewHolder, mItemConfig, item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onClicked(item);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 0 && position < mItemList.size()) {
            return mItemList.get(position).getViewType().ordinal();
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    /**
     * Add item to the list.
     * @param item
     */
    public void addItem(IScrollViewItem item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be not NULL");
        }
        mItemList.add(item);
    }

    /**
     * Remove an item from the list.
     * @param item
     */
    public void removeItem(IScrollViewItem item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be not NULL");
        }
        mItemList.remove(item);
    }

    /**
     * Clear all item from the list.
     */
    public void clearItems() {
        mItemList.clear();
    }

    /**
     * Select an item from a position.
     * @param position
     * @return
     */
    public IScrollViewItem select(int position) {
        if (position < 0 || position >= mItemList.size()) {
            throw new IllegalArgumentException("The position is in-valid");
        }
        // unSelect all items in list.
        for (IScrollViewItem item : mItemList) {
            setSelectForScrollViewItem(item, false);
        }

        // Select item with the position.
        IScrollViewItem item = mItemList.get(position);
        setSelectForScrollViewItem(item, true);
        return item;
    }

    /**
     * Select an item.
     * @param item
     */
    public void select(IScrollViewItem item) {
        if (item == null) {
            throw new IllegalArgumentException("The position is in-valid");
        }
        // Un-Select all items from the list.
        for (IScrollViewItem i : mItemList) {
            setSelectForScrollViewItem(i, false);
        }

        // Select required item.
        setSelectForScrollViewItem(item, true);
    }

    private void setSelectForScrollViewItem(IScrollViewItem item, boolean isSelect) {
        if (item instanceof SelectableItem) {
            ((SelectableItem) item).setSelected(isSelect);
        }
    }
}
