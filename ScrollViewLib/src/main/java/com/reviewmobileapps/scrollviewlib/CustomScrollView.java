package com.reviewmobileapps.scrollviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.reviewmobileapps.scrollviewlib.items.IScrollViewItem;
import com.reviewmobileapps.scrollviewlib.selector.HorizontalSelector;

public class CustomScrollView extends RelativeLayout implements ScrollViewAdapter.IOnItemClickListener {

    private static final int DEFAULT_ITEM_WIDTH = 100;

    private static final int DEFAULT_ITEM_HEIGHT = 100;

    private static final int DEFAULT_ITEM_MARGIN_TOP = 5;

    private static final int DEFAULT_ITEM_MARGIN_BOTTOM = 5;

    private static final int DEFAULT_ITEM_MARGIN_LEFT = 5;

    private static final int DEFAULT_ITEM_MARGIN_RIGHT = 5;

    private static final int DEFAULT_ITEM_TEXT_SIZE = 12;

    private static final int DEFAULT_ITEM_TEXT_COLOR = Color.parseColor("#FFFFFF");

    private static final int DEFAULT_ITEM_BACKGROUND_COLOR = Color.parseColor("#000000");

    private static final int DEFAULT_ITEM_COLOR_SELECTED = Color.parseColor("#0099cc");

    private static final int ORIENTATION_VERTICAL = 1;

    private static final int ORIENTATION_HORIZONTAL = 2;

    private final ScrollViewConfig mItemConfig;

    private final boolean mIsSelectable;

    private final int mOrientation;

    private RecyclerView mRecyclerView;

    private ScrollViewAdapter mScrollViewAdapter;

    private ScrollViewCallback mScrollViewCallback;

    public CustomScrollView(Context context) {
        this(context, null);
    }

    public CustomScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomScrollView, 0, 0);
        int icon_height = a.getDimensionPixelSize(R.styleable.CustomScrollView_item_height, DEFAULT_ITEM_HEIGHT);
        int icon_width = a.getDimensionPixelSize(R.styleable.CustomScrollView_item_width, DEFAULT_ITEM_WIDTH);
        int item_textColor = a.getColor(R.styleable.CustomScrollView_item_textColor, DEFAULT_ITEM_TEXT_COLOR);
        int item_backgroundColor = a.getColor(R.styleable.CustomScrollView_item_backgroundColor, DEFAULT_ITEM_BACKGROUND_COLOR);
        int item_colorSelected = a.getColor(R.styleable.CustomScrollView_item_colorSelected, DEFAULT_ITEM_COLOR_SELECTED);
        int item_marginTop = a.getDimensionPixelSize(R.styleable.CustomScrollView_item_marginTop, DEFAULT_ITEM_MARGIN_TOP);
        int item_marginBottom = a.getDimensionPixelSize(R.styleable.CustomScrollView_item_marginBottom, DEFAULT_ITEM_MARGIN_BOTTOM);
        int item_marginLeft = a.getDimensionPixelSize(R.styleable.CustomScrollView_item_marginLeft, DEFAULT_ITEM_MARGIN_LEFT);
        int item_marginRight = a.getDimensionPixelSize(R.styleable.CustomScrollView_item_marginRight, DEFAULT_ITEM_MARGIN_RIGHT);
        int item_textSize = a.getDimensionPixelSize(R.styleable.CustomScrollView_item_textSize, DEFAULT_ITEM_TEXT_SIZE);
        mOrientation = a.getInt(R.styleable.CustomScrollView_orientation, CustomScrollView.ORIENTATION_HORIZONTAL);
        mIsSelectable = a.getBoolean(R.styleable.CustomScrollView_item_selectable, false);
        a.recycle();

        mItemConfig = new ScrollViewConfig(icon_width, icon_height, item_textColor, item_backgroundColor
                , item_marginTop, item_marginBottom, item_marginLeft
                , item_marginRight, item_colorSelected, item_textSize);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_scroll_view, this, true);
        initViews();
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewItems);
        int orientation = mOrientation == ORIENTATION_HORIZONTAL ? LinearLayoutManager.HORIZONTAL : LinearLayoutManager.VERTICAL;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), orientation, false));

        mScrollViewAdapter = new ScrollViewAdapter(getContext(), mItemConfig, new HorizontalSelector(), this);
        mRecyclerView.setAdapter(mScrollViewAdapter);
    }

    /**
     * Add item to {@link CustomScrollView}
     * @param item
     */
    public void addItem(IScrollViewItem item) {
        mScrollViewAdapter.addItem(item);
    }

    /**
     * Clear all items in {@link CustomScrollView}
     */
    public void clear() {
        mScrollViewAdapter.clearItems();
    }

    /**
     * Notify to update View after changed the data.
     * This method should call after add/remove/update the data.
     */
    public void notifyUpdateData() {
        mScrollViewAdapter.notifyItemRangeChanged(0, mScrollViewAdapter.getItemCount());
        mScrollViewAdapter.notifyDataSetChanged();
    }

    /**
     * Set callback to listen to view events.
     * @param callback
     */
    public void setHorizontalCallback(ScrollViewCallback callback) {
        mScrollViewCallback = callback;
    }

    /**
     * Select a position in view.
     * Then, that item will show white bottom line.
     * @param position
     */
    public void select(int position) {
        if (!mIsSelectable) {
            return;
        }
        IScrollViewItem item = mScrollViewAdapter.select(position);
        notifyUpdateData();
        if (mScrollViewCallback != null) {
            mScrollViewCallback.onClick(item.getType());
        }
    }

    @Override
    public void onClicked(IScrollViewItem item) {
        if (mIsSelectable) {
            mScrollViewAdapter.select(item);
            notifyUpdateData();
        }
        if (mScrollViewCallback != null) {
            mScrollViewCallback.onClick(item.getType());
        }
    }
}
