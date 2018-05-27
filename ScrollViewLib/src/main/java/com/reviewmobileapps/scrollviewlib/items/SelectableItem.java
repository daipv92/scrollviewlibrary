package com.reviewmobileapps.scrollviewlib.items;

/**
 * Implement common function for selectable scroll view item.
 */
public abstract class SelectableItem implements IScrollViewItem {

    private boolean mIsSelected;

    public void setSelected(boolean isSelected) {
        mIsSelected = isSelected;
    }

    public boolean isSelected() {
        return mIsSelected;
    }

}
