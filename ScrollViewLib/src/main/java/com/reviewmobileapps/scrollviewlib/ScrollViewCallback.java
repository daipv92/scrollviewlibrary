package com.reviewmobileapps.scrollviewlib;

import com.reviewmobileapps.scrollviewlib.items.IScrollViewItem;

/**
 * The callback to listen view events from {@link CustomScrollView}
 */
public interface ScrollViewCallback {

    /**
     * On click event.
     * @param viewType
     */
    void onClick(IScrollViewItem.Type viewType);
}
