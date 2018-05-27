package com.reviewmobileapps.scrollviewlib;

/**
 * Save all configs of {@link CustomScrollView}
 */
public class ScrollViewConfig {

    private int mItemWidth;

    private int mItemHeight;

    private int mItemTextColor;

    private int mItemBackgroundColor;

    private int mItemMarginTop;

    private int mItemMarginBottom;

    private int mItemMarginLeft;

    private int mItemMarginRight;

    private int mItemColorSelected;

    private int mItemTextSize;

    public ScrollViewConfig(int itemWidth, int itemHeight, int itemTextColor, int itemBackgroundColor
            , int itemMarginTop, int itemMarginBottom, int itemMarginLeft, int itemMarginRight
            , int itemColorSelected, int itemTextSize) {
        mItemWidth = itemWidth;
        mItemHeight = itemHeight;
        mItemTextColor = itemTextColor;
        mItemBackgroundColor = itemBackgroundColor;
        mItemMarginTop = itemMarginTop;
        mItemMarginBottom = itemMarginBottom;
        mItemMarginLeft = itemMarginLeft;
        mItemMarginRight = itemMarginRight;
        mItemColorSelected = itemColorSelected;
        mItemTextSize = itemTextSize;
    }

    public int getItemWidth() {
        return mItemWidth;
    }

    public int getItemHeight() {
        return mItemHeight;
    }

    public int getItemTextColor() {
        return mItemTextColor;
    }

    public int getItemBackgroundColor() {
        return mItemBackgroundColor;
    }

    public int getItemMarginTop() {
        return mItemMarginTop;
    }

    public int getItemMarginBottom() {
        return mItemMarginBottom;
    }

    public int getItemMarginLeft() {
        return mItemMarginLeft;
    }

    public int getItemMarginRight() {
        return mItemMarginRight;
    }

    public int getItemColorSelected() {
        return mItemColorSelected;
    }

    public int getItemTextSize() {
        return mItemTextSize;
    }
}
